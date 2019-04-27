
public class Player {
	private String name;
	private int score;
	
	public Player(String a, int b) {
		this.name=a;
		this.score=b;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
