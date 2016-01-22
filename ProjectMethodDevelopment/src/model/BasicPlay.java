package model;

public class BasicPlay implements IPlay {
	Integer num;
	Player player;
	Integer scoreForLvlUp;
	Integer time;
	
	public BasicPlay() {
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getScoreForLvlUp() {
		return scoreForLvlUp;
	}

	public void setScoreForLvlUp(Integer scoreForLvlUp) {
		this.scoreForLvlUp = scoreForLvlUp;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}
}
