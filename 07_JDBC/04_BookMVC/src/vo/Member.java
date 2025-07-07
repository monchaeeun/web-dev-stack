package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {// -->client_info

	private String id; //primary key
	private String name;
	private String pwd;
	private int age;
	
}
