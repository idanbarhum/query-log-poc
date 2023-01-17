package isb.querylogpoc;

import isb.querylogpoc.entity.TestEntity;
import isb.querylogpoc.entity.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class QueryLogPocApplication {

	@Autowired
	private TestEntityRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(QueryLogPocApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				repository.saveAll(generateEntities());
			}
		};
	}

	private List<TestEntity> generateEntities() {
		return IntStream.range(1, 5)
				.mapToObj(i ->
						new TestEntity()
								.setString(String.format("Entity %d", i))
								.setInteger(10 * i))
				.toList();
	}

}
