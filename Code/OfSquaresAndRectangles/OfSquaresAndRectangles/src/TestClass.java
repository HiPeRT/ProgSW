import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
class TestClass {
	
	@ParameterizedTest
	@MethodSource("instancesToTest")
	public void test(ASquaredShape _sut) {
		// Arrange
		double areaBefore = _sut.calcArea();
		_sut.setHeight(_sut.getHeight() * 2);
		
		// Act		
		double areaAfter = _sut.calcArea();
		
		// Assert
		Assertions.assertEquals(areaBefore * 2, areaAfter);
	}
	
	@Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                new Object[]{new Rettangolo(2, 3)},
                new Object[]{new Rettangolo(21, 31)},
                new Object[]{new Quadrato(2)}
        );
    }
}
