package unic.domino.pizza.clone.server.test.entity;

import javax.persistence.*;

import lombok.*;

@Entity 
@Table(name = "tbl_memo") 
@ToString
@Getter
@Builder 
@AllArgsConstructor 
@NoArgsConstructor 
public class Memo { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	//MySQL의 AUTO_INCREMENT를 사용 
	private Long id;
	@Column(length = 200, nullable = false) 
	private String memoText;
}


