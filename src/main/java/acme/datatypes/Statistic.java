
package acme.datatypes;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Statistic {

	int		count;
	Double	average;
	Double	deviation;
	Double	maximum;
	Double	minimum;


	public void calculateAverage(final Collection<Double> values) {
		double res = 0.0;
		if (!values.isEmpty()) {
			final Double totalSum = values.stream().mapToDouble(Double::doubleValue).sum();
			res = totalSum / values.size();
		}
		this.average = res;
	}

	public void calculateDeviation(final Collection<Double> values) {
		Double res = 0.0;
		double aux = 0.0;
		if (!values.isEmpty()) {
			for (final Double value : values)
				aux += Math.pow(value - this.average, 2);
			res = Math.sqrt(aux / values.size());
		}
		this.deviation = res;
	}

	public void calculateMaximum(final Collection<Double> values) {
		final Double max = values.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
		this.maximum = max;
	}

	public void calculateMinimum(final Collection<Double> values) {
		final Double min = values.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
		this.maximum = min;
	}

	@Override
	public String toString() {
		return "Statistic [count=" + this.count + ", average=" + this.average + ", deviation=" + this.deviation + ", maximum=" + this.maximum + ", minimum=" + this.minimum + "]";
	}

}
