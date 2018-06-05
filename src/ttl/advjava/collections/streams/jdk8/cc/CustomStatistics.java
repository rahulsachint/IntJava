package ttl.advjava.collections.streams.jdk8.cc;

public class CustomStatistics {
	private int maxX = Integer.MIN_VALUE;
	private int maxY = Integer.MIN_VALUE;
	private int minX = Integer.MAX_VALUE;
	private int minY = Integer.MAX_VALUE;
	
	private int count = 0;
	
	/**
	 * Add data to this CustomStatics object
	 * @param d
	 */
	public void accumulate(Data d) {
		this.maxX = Math.max(this.maxX,  d.xValue);
		this.maxY = Math.max(this.maxY,  d.yValue);
		
		this.minX = Math.min(this.minX, d.xValue);
		this.minY = Math.min(this.minY, d.yValue);
		
		this.count++;
	}

	public static void accumulateStatic(CustomStatistics cs, Data d) {
		cs.maxX = Math.max(cs.maxX,  d.xValue);
		cs.maxY = Math.max(cs.maxY,  d.yValue);
		
		cs.minX = Math.min(cs.minX, d.xValue);
		cs.minY = Math.min(cs.minY, d.yValue);
		
		cs.count++;
	}
	
	/**
	 * Combine this CustomStatistics object with c2.
	 * Only done if using a parallel Stream
	 * @param c2
	 */
	public void combine(CustomStatistics c2) {
		this.maxX = Math.max(this.maxX, c2.maxX);
		this.maxY = Math.max(this.minY, c2.maxY);

		this.minX = Math.min(this.minX, c2.minX);
		this.minY = Math.min(this.minY, c2.minY);
		
		this.count += c2.count;
	}

	/**
	 * A final opportunity to massage the result.
	 * Only called with using the 4 arg Collectors call
	 * Collectors.of(supplier, accum, combine, finish)
	 * and, you would have to change the accum, combine etc.
	 * methods to be static, with two arguments.
	 * @param almostFinal
	 * @return
	 */
	public CustomStatistics finisher(CustomStatistics almostFinal) {
		//Might calculate averages and deviations here and add them to the result
		
		return almostFinal;
	}

	@Override
	public String toString() {
		return "CustomStatistics [maxX=" + maxX + ", maxY=" + maxY + ", minX=" + minX + ", minY=" + minY + ", count="
				+ count + "]";
	}
	
}
