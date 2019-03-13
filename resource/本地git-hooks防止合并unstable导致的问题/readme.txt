友情提示: 道路千万条,安全第一条,误合unstable,同事两行泪

把上述文件放置在项目的.git/hooks/路径下,给这些文件增加可执行权限chmond +x *
即可防止合并unstable和tc-unstable后提交或推送代码,导致代码混乱,
例如component/.git/hooks/路径下.

如果合并了unstbale分支, 本地会自动创建MERGE_UNSTABLE_ISSUE*分支,在commit和push操作的时候会检查该分支,以执行阻止.
