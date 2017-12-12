package com.ddabadi.pos;

import com.ddabadi.pos.domain.Sales;
import com.ddabadi.pos.domain.repository.SalesRepository;

// @DataJpaTest
public class PosApplicationTests {

    /*
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired private SalesRepository salesRepository;

    @Test
    public void should_find_null_sales_if_sales_is_empty(){
        Iterable<Sales> saleses= salesRepository.findAll();
        assertThat(saleses).isEmpty();
    }

	@Test
	public void should_store_sales() {
        Sales sales = new Sales();
        sales.setNama("Deddy");
        sales.setKota("Jakarta");
        sales.setNIK("123");
        sales=salesRepository.save(sales);

        assertThat(sales).hasFieldOrPropertyWithValue("nama","Deddy");
        assertThat(sales).hasFieldOrPropertyWithValue("kota","Jakarta");
        assertThat(sales).hasFieldOrPropertyWithValue("NIK","123");

	}

    @Test
    public void Should_find_all_sales(){
        Sales sales1 = new Sales();
        sales1.setId(0L);
        sales1.setNama("Deddy");
        salesRepository.save(sales1);

        Sales sales2 = new Sales();
        sales2.setId(0L);
        sales2.setNama("Joe");
        salesRepository.save(sales2);

        Iterable<Sales> saleses = salesRepository.findAll();

        assertThat(saleses).hasSize(2).contains(sales1, sales2);

    }

    @Test
    public void Should_find_one_sales(){
        Sales sales1 = new Sales();
        sales1.setId(0L);
        sales1.setNama("Deddy");
        //testEntityManager.persist(sales1);

        Sales sales2 = new Sales();
        sales2.setId(0L);
        sales2.setNama("Joe");
        //testEntityManager.persist(sales2);

        Sales sales = salesRepository.findOne(sales2.getId());

        assertThat(sales).isEqualTo(sales2);

    }
     */


}
