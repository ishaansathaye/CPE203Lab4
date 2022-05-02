import java.util.*;

public class CommunityMember {
	private CMemberKind kind;
	private float money;
	private ArrayList<Float> moneyOverTime;
    Random random = new Random();
	private int red, green, blue;
	private Set<Integer> lottoNumbers;

	//constructor
	public CommunityMember(CMemberKind pK, float startFunds) {
		this.kind = pK;
		this.money = startFunds;
		this.moneyOverTime = new ArrayList<Float>();
		this.moneyOverTime.add(startFunds);
		this.red = this.random.nextInt(100);
		this.green = this.random.nextInt(100);
		this.blue = this.random.nextInt(100);
		this.lottoNumbers = new HashSet<Integer>();

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

	public void addMoney(float amount) {
		this.money += amount;
	}

	public Set<Integer> getLottoNumbers() {
		return this.lottoNumbers;
	}

	public void playRandom() {
		//generates 5 numbers between 1 and 42 (inclusive)
		this.lottoNumbers.clear();
		int min = 1;
		int max = 42;
		while (this.lottoNumbers.size() < 5) {
			int randomNum = this.random.nextInt(min, max + 1);
			this.lottoNumbers.add(randomNum);
		}
	}


}
