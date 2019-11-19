package bank.tests.unit;

import bank.Statement;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StatementTest {
    @Test
    public void create_and_empty_statement() {
        Statement statement = new Statement();

        assertThat(statement.transactions.size(), is(0));
    }


}
