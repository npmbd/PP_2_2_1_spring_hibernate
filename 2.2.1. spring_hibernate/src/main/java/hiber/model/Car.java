package hiber.model;

import javax.persistence.*;

@Entity
@Table(name="car")
public class Car {

    @Id
    @Column(name="id")
    private long id;

    @Column(name="model")
    private String model;

    @Column(name="series")
    private int series;

    @OneToOne
    @MapsId
    @JoinColumn(name="id")
    private User user;

    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() { return user; }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                ", userName=" + user.getFirstName() +
                '}';
    }
}