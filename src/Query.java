import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 33558 on 19.01.2017.
 */
@XmlRootElement
public class Query {
    @XmlElement
    private Results results;

    @Override
    public String toString() {
        return "Query{" +
                "results=" + results.toString() +
                '}';
    }
}

