import java.util.HashMap;
import java.util.Map;

public class MotorcycleManager {
    private Map<String, Motorcycle> prototypes = new HashMap<>();

    {
        prototypes.put("sport",
                new Motorcycle("Kawasaki", "Ninja")
                        .engine(new Engine(
                                new Type("Inline-4"))
                                .displacement(1000f)
                                .horsePower(125))
                        .yearOfProduction(2017));

        prototypes.put("cruiser",
                new Motorcycle("Harley-Davidson", "Iron 883")
                        .engine(new Engine(
                                new Type("Evolution"))
                                .displacement(883)
                                .horsePower(61))
                        .yearOfProduction(2019));


        prototypes.put("tourer",
                new Motorcycle("BMW", "F850GS")
                        .engine(new Engine(
                                new Type("2-cylinder"))
                                .displacement(853)
                                .horsePower(95))
                        .yearOfProduction(2015));

    }

    // DEEP COPY
    public Motorcycle getMotorPrototype(String type) {
        return prototypes.get(type).clone();
    }

    // SHALLOW COPY
    public Motorcycle getMotorShallowCopy(String type) {
        return prototypes.get(type).shallowCopy();
    }
}
