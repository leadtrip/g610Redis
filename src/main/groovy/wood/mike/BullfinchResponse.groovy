package wood.mike

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("bullfinchresponses")
class BullfinchResponse {
	@Id String id
	List<String> styles
	String body

	BullfinchResponse(List<String> styles, String body) {
		this.styles = styles
		this.body = body
	}


	@Override
	String toString() {
		return "BullfinchResponse{" +
				"id='" + id + '\'' +
				", styles=" + styles.size() +
				", body='" + body + '\'' +
				'}';
	}
}
