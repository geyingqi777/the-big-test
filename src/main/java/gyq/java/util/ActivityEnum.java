package gyq.java.util;

public enum ActivityEnum {
		ACTIVITY_ENUM1(1, 1), ACTIVITY_ENUM2(2, 2);
		private int activityId;
		private int activityType;

		ActivityEnum(int activityId, int activityType) {
			activityId = activityId;
			activityType = activityType;
		}

		public int getActivityType() {
			return activityType;
		}

		public void setActivityType(int activityType) {
			this.activityType = activityType;
		}

		public int getActivityId() {
			return activityId;
		}

		public void setActivityId(int activityId) {
			this.activityId = activityId;
		}
	}