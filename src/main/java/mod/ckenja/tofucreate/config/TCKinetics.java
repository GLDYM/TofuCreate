package mod.ckenja.tofucreate.config;


import net.createmod.catnip.config.ConfigBase;

public class TCKinetics extends ConfigBase {


    public final TCStress stressValues = nested(1, TCStress::new, Comments.stress);

    @Override
    public String getName() {
        return "kinetics";
    }

    private static class Comments {

        static String stress = "kinetic stats";

    }
}
