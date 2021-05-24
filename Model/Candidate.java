package Model;

public class Candidate{  //후보자 정보
	private String id; //선거 ID
	private String name;
	private String jdName;
	private String birthday;
	private String career;
	
	public Candidate() {
		super();
	}
	public Candidate(String id, String name, String jdName, String birthday, String career) {
		super();
		this.id = id;
		this.name = name;
		this.jdName = jdName;
		this.birthday = birthday;
		this.career = career;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJdName() {
		return jdName;
	}
	public void setJdName(String jdName) {
		this.jdName = jdName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}    
	@Override
    public String toString() {
        return "Candidate [id=" + id + ", name=" + name + ", jdname=" + jdName + ", birthday=" + birthday + ", career=" + career + "]";
    }

}
