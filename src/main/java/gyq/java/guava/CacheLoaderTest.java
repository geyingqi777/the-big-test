package gyq.java.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author geyingqi
 * @date 2019-09-27 18:09
 */
@Slf4j
public class CacheLoaderTest {
    @Test
    public void test1() throws ExecutionException {
        // 模拟数据库或配置中的数据
        Map<String, String> fromDbOrConfig = ImmutableMap.of("3", "v3");

        CacheLoader<String, String> cacheLoader = new CacheLoader<String, String>() {
            @Override
            public String load(String s) throws Exception {
                // 2019-09-27 可以自定义如果本地缓存中找不到值的时候, 从哪里加载初始化数据的逻辑,例如从数据中查询
                String value = fromDbOrConfig.getOrDefault(s, null);
                log.info("从其他地方加载 {} {}", s, value);
                return value;
            }
        };
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                //设置缓存上线
                // TODO: 2019-09-27 可以设置小一点试一下到达最大时,再put的处理策略 
                .maximumSize(10000)
                //设置时间对象没有被读/写访问则对象从内存中删除
                .expireAfterAccess(10, TimeUnit.MINUTES)
                //设置时间对象没有被写访问则对象从内存中删除
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(cacheLoader);
        // 可以随时put进来一个
        cache.put("1", "v1");
        log.info(cache.get("1"));

        // 值的注意的这个地方如果得到了null值,会抛异常com.google.common.cache.CacheLoader$InvalidCacheLoadException: CacheLoader returned null for key
        try {
            log.info(cache.get("2"));
        } catch (Exception e) {
            log.error("{} {}", e.getClass(), e.getMessage());
        }
        // 此方法得到null不会抛异常,会返回null,但是这个不会调用load去加载这个值
        log.info(cache.getIfPresent("2"));
        log.info(cache.get("3"));
        // 重新加载某个值
        cache.refresh("3");
    }
}
