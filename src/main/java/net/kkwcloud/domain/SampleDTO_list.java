package net.kkwcloud.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data //lombok에서 getter/setter, toString() , equals() 생성함
public class SampleDTO_list {

	private List<SampleDTO> lists;
	
	//생성자 : 인스턴스 생성시 ArrayList lists가 생긴다.
	public SampleDTO_list() {
		lists = new ArrayList<>();
		
	}
	
}//class end
