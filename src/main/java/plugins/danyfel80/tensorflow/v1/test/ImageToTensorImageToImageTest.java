package plugins.danyfel80.tensorflow.v1.test;

import org.bioimageanalysis.icy.tensorflow.v1.tensor.TensorBuilder;
import org.tensorflow.Tensor;

/**
 * Test Plugin taking the first image of a sequence and converting it to tensor and back to image, using the specified tensor dimension order.
 * 
 * @author Daniel Felipe Gonzalez Obando
 */
public class ImageToTensorImageToImageTest
{
   /* private EzVarSequence varInSequence;
    private EzVarIntegerArrayNative varInTensorDimOrder;

    @Override
    protected void initialize()
    {
        varInSequence = new EzVarSequence("Sequence (only one image)");
        varInTensorDimOrder = new EzVarIntegerArrayNative("Tensor dimension order", new int[][] {{0, 2, 1}}, true);
        addEzComponent(varInSequence);
        addEzComponent(varInTensorDimOrder);
    }

    @Override
    protected void execute()
    {
        Sequence image = varInSequence.getValue(true);
        int[] tensorDimOrder = varInTensorDimOrder.getValue(true);
        if (tensorDimOrder.length != 3)
            throw new IllegalArgumentException("Tensor dimension order length is not correct.");

        long tStart = 0, tTensor = 0, tResult = 0;
        tStart = System.currentTimeMillis();
        try (Tensor<?> tensor = TensorBuilder.build(image, tensorDimOrder))
        {
            tTensor = System.currentTimeMillis();
            IcyBufferedImage rebuiltImage = IcyBufferedImageBuilder.build(tensor, tensorDimOrder);
            tResult = System.currentTimeMillis();
            addSequence(new Sequence(rebuiltImage));
        }

        long tConversion1 = tTensor - tStart;
        long tConversion2 = tResult - tTensor;
        System.out.println("Conversion to tensor = " + tConversion1 + "msec");
        System.out.println("Conversion to image = " + tConversion2 + "msec");
    }

    @Override
    public void clean()
    {
    }

    public static void main(String[] args)
    {
        Icy.main(args);
        PluginLauncher.start(PluginLoader.getPlugin(ImageToTensorImageToImageTest.class.getName()));
    }
*/
}
