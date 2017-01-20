import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 33558 on 19.01.2017.
 */
@XmlRootElement
public class Rate {
    @XmlAttribute
    private String id;
    @XmlElement
    private String Name;
    @XmlElement
    private double Rate;
    @XmlElement
    private String Date;
    @XmlElement
    private String Time;
    @XmlElement
    private String Ask;
    @XmlElement
    private String Bit;

    public Rate() {
    }

    public Rate(String id, String name, double rate, String date, String time, String ask, String bit) {
        this.id = id;
        Name = name;
        Rate = rate;
        Date = date;
        Time = time;
        Ask = ask;
        Bit = bit;
    }

    @Override
    public String toString() {
        return "\n"+"Rate{" +
                "id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                ", Rate=" + Rate +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                ", Ask='" + Ask + '\'' +
                ", Bit='" + Bit + '\'' +
                '}' ;
    }
}
