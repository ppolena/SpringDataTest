package main.java.SpringDataTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataTestApplicationTests {

	@Autowired
	private PersonRepository prep;

	@Autowired
	private CarRepository crep;

	@Test
	public void test1() {

		Person p = new Person();
		p.setName("Polgar Jeno");
		p.setTelnum("123456");
		prep.save(p);

		assertThat(prep.findAll().get(0).getId()).isEqualTo((long)1);
		assertThat(prep.findAll().get(0).getName()).isEqualTo("Polgar Jeno");
		assertThat(prep.findAll().get(0).getTelnum()).isEqualTo("123456");
	}

	@Test
	public void test2() {

		Car c = new Car();
		c.setBrand("Ford");
		c.setName("Mustang");
		c.setYear(1967);
		c.setCondition(Condition.valueOf("Excellent"));
		crep.save(c);

		assertThat(crep.findAll().get(0).getId()).isEqualTo((long)2);
		assertThat(crep.findAll().get(0).getBrand()).isEqualTo("Ford");
		assertThat(crep.findAll().get(0).getName()).isEqualTo("Mustang");
		assertThat(crep.findAll().get(0).getYear()).isEqualTo(1967);
		assertThat(crep.findAll().get(0).getCondition()).isEqualTo(Condition.valueOf("Excellent"));
	}

	@Test
	public void test3() {

		Car c = new Car();
		c.setBrand("Ford");
		c.setName("Focus");
		c.setYear(1967);
		c.setCondition(Condition.valueOf("Good"));
		crep.save(c);

		assertThat(crep.findAll().get(1).getId()).isEqualTo((long)3);
	}

	@Test
	public void test4() {

		System.out.println(crep.findById((long)2).get().getBrand());
		crep.updateCarSetBrandForIdNative("Dodge", (long)2);
		assertThat(crep.findById((long)2).get().getBrand()).isEqualTo("Dodge");
		System.out.println(crep.findById((long)2).get().getBrand());

		System.out.println(crep.findById((long)2).get().getName());
		crep.updateCarSetNameForIdNative("Charger", (long)2);
		assertThat(crep.findById((long)2).get().getName()).isEqualTo("Charger");
		System.out.println(crep.findById((long)2).get().getName());

		System.out.println(crep.findById((long)2).get().getYear());
		crep.updateCarSetYearForIdNative(1970, (long)2);
		assertThat(crep.findById((long)2).get().getYear()).isEqualTo(1970);
		System.out.println(crep.findById((long)2).get().getYear());

		System.out.println(crep.findById((long)2).get().getCondition());
		crep.updateCarSetConditionForIdNative( 3, (long)2);
		assertThat(crep.findById((long)2).get().getCondition()).isEqualTo(Condition.Bad);
		System.out.println(crep.findById((long)2).get().getCondition());

		crep.updateCarSetOwnerForIdNative(prep.findById((long)1).get(), (long)2);
		assertThat(prep.findById((long)1).get().getId()).isEqualTo(crep.findById((long)2).get().getOwner().getId());
		assertThat(prep.findById((long)1).get().getOwnedCars().size()).isEqualTo(1);
	}

    @Test
	public void test5(){
        System.out.println(prep.findById((long)1).get().getName());
        prep.updatePersonSetNameForIdNative("Szalacsi Sandor", (long)1);
        assertThat(prep.findById((long)1).get().getName()).isEqualTo("Szalacsi Sandor");
        System.out.println(prep.findById((long)1).get().getName());

        System.out.println(prep.findById((long)1).get().getTelnum());
        prep.updatePersonSetTelnumForIdNative("654321", (long)1);
        assertThat(prep.findById((long)1).get().getTelnum()).isEqualTo("654321");
        System.out.println(prep.findById((long)1).get().getTelnum());
    }

}
