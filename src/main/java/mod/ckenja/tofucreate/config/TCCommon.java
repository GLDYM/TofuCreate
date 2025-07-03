package mod.ckenja.tofucreate.config;


import net.createmod.catnip.config.ConfigBase;

public class TCCommon extends ConfigBase {

    public final TCKinetics kinetics = nested(0, TCKinetics::new, Comments.kinetics);

    @Override
    public String getName() {
        return "common";
    }

    private static class Comments {
        static String kinetics = "CEC blocks comportements";

    }
}
