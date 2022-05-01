import java.util.*;

public class CommunityMember {
	private CMemberKind kind;
	private float money;
	private ArrayList<Float> moneyOverTime;
    Random random = new Random();
	private int red, green, blue;

	//constructor
	public CommunityMember(CMemberKind pK, float startFunds) {
		this.kind = pK;
		this.money = startFunds;
		this.moneyOverTime = new ArrayList<Float>();
		this.moneyOverTime.add(startFunds);
		this.red = this.random.nextInt(100);
		this.green = this.random.nextInt(100);
		this.blue = this.random.nextInt(100);

		//overall blue tint to POORLY_PAID	
		if (this.kind == CMemberKind.WELL_PAID) {
			this.red += 100;
		} else {
			this.blue += 100;
		}
	}

	public int getR() { return this.red; }
	public int getG() { return this.green; }
	public int getB() { return this.blue; }
	public float getMoney() { return this.money; }
	public CMemberKind getKind() { return this.kind; }
	public ArrayList<Float> getFunds() { return this.moneyOverTime; }

	public void updateMoneyEachYear() {
		this.moneyOverTime.add(this.money);
	}

}
