package org.bioimageanalysis.icy.tensorflow.v1.tensor;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.tensorflow.Tensor;
import org.tensorflow.types.UInt8;

import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDManager;
import ai.djl.ndarray.types.Shape;

/**
 * A {@link Sequence} builder for TensorFlow {@link Tensor} objects.
 * 
 * @author Carlos Garcia Lopez de Haro
 */
public final class NDArrayBuilder
{

    /**
     * Not used (Utility class).
     */
    private NDArrayBuilder()
    {
    }

    /**
     * Creates a {@link Sequence} from a given {@link Tensor} and an array with its dimensions order.
     * 
     * @param tensor
     *        The tensor data is read from.
     * @param tensorDimOrder
     *        The tensor dimension order. It must be of the same size as the tensor dimSize. e.g. [4,3,2,0,1] = Result sequence will have as x dimension (0) the
     *        fourth dimension of the tensor, as y dimension(1) the fifth dimension of the tensor, as c dimension (2) the third dimension of the tensor, z (3) =
     *        2nd tensor dimension, and t(4) = 1st tensor dimension.
     * @return The sequence built from the tensor.
     * @throws IllegalArgumentException
     *         If the tensor type is not supported.
     */
    @SuppressWarnings("unchecked")
    public static NDArray build(Tensor<?> tensor, NDManager manager) throws IllegalArgumentException
    {
        // Create an Icy sequence of the same type of the tensor
        switch (tensor.dataType())
        {
            case UINT8:
                return buildFromTensorByte((Tensor<UInt8>) tensor, manager);
            case INT32:
                return buildFromTensorInt((Tensor<Integer>) tensor, manager);
            case FLOAT:
                return buildFromTensorFloat((Tensor<Float>) tensor, manager);
            case DOUBLE:
                return buildFromTensorDouble((Tensor<Double>) tensor, manager);
            default:
                throw new IllegalArgumentException("Unsupported tensor type: " + tensor.dataType());
        }
    }

    /**
     * Builds a {@link Sequence} from a unsigned byte-typed {@link Tensor}.
     * 
     * @param tensor
     *        The tensor data is read from.
     * @param tensorDimOrder
     *        The tensor dimension order. It must be of the same size as the tensor dimSize. e.g. [4,3,2,0,1] = Result sequence will have as x dimension (0) the
     *        fourth dimension of the tensor, as y dimension(1) the fifth dimension of the tensor, as c dimension (2) the third dimension of the tensor, z (3) =
     *        2nd tensor dimension, and t(4) = 1st tensor dimension.
     * @return The sequence built from the tensor of type {@link DataType#UBYTE}.
     */
    public static NDArray buildFromTensorByte(Tensor<UInt8> tensor, NDManager manager)
    {
    	long[] tensorShape = tensor.shape();
		int totalSize = 1;
		for (long i : tensorShape) {totalSize *= i;}
        byte[] flatImageArray = new byte[totalSize];
		ByteBuffer outBuff = ByteBuffer.wrap(flatImageArray);
	 	tensor.writeTo(outBuff);
	 	NDArray ndarray = manager.create(flatImageArray, new Shape(tensorShape));
		
		return ndarray;
	}

    /**
     * Builds a {@link Sequence} from a unsigned integer-typed {@link Tensor}.
     * 
     * @param tensor
     *        The tensor data is read from.
     * @param tensorDimOrder
     *        The tensor dimension order. It must be of the same size as the tensor dimSize. e.g. [4,3,2,0,1] = Result sequence will have as x dimension (0) the
     *        fourth dimension of the tensor, as y dimension(1) the fifth dimension of the tensor, as c dimension (2) the third dimension of the tensor, z (3) =
     *        2nd tensor dimension, and t(4) = 1st tensor dimension.
     * @return The sequence built from the tensor of type {@link DataType#INT}.
     */
    public static NDArray buildFromTensorInt(Tensor<Integer> tensor, NDManager manager)
    {
		long[] tensorShape = tensor.shape();
		int totalSize = 1;
		for (long i : tensorShape) {totalSize *= i;}
    	int[] flatImageArray = new int[totalSize];
    	IntBuffer outBuff = IntBuffer.wrap(flatImageArray);
	 	tensor.writeTo(outBuff);
	 	NDArray ndarray = manager.create(flatImageArray, new Shape(tensorShape));
	 	return ndarray;
    }

    /**
     * Builds a {@link Sequence} from a unsigned float-typed {@link Tensor}.
     * 
     * @param tensor
     *        The tensor data is read from.
     * @param tensorDimOrder
     *        The tensor dimension order. It must be of the same size as the tensor dimSize. e.g. [4,3,2,0,1] = Result sequence will have as x dimension (0) the
     *        fourth dimension of the tensor, as y dimension(1) the fifth dimension of the tensor, as c dimension (2) the third dimension of the tensor, z (3) =
     *        2nd tensor dimension, and t(4) = 1st tensor dimension.
     * @return The sequence built from the tensor of type {@link DataType#FLOAT}.
     */
    public static NDArray buildFromTensorFloat(Tensor<Float> tensor, NDManager manager)
    {
		long[] tensorShape = tensor.shape();
		int totalSize = 1;
		for (long i : tensorShape) {totalSize *= i;}
		float[] flatImageArray = new float[totalSize];
		FloatBuffer outBuff = FloatBuffer.wrap(flatImageArray);
	 	tensor.writeTo(outBuff);
	 	NDArray ndarray = manager.create(flatImageArray, new Shape(tensorShape));
	 	return ndarray;
    }

    /**
     * Builds a {@link NDArray} from a unsigned double-typed {@link Tensor}.
     * 
     * @param tensor
     *        The tensor data is read from.
     * @param tensorDimOrder
     *        The tensor dimension order. It must be of the same size as the tensor dimSize. e.g. [4,3,2,0,1] = Result sequence will have as x dimension (0) the
     *        fourth dimension of the tensor, as y dimension(1) the fifth dimension of the tensor, as c dimension (2) the third dimension of the tensor, z (3) =
     *        2nd tensor dimension, and t(4) = 1st tensor dimension.
     * @return The sequence built from the tensor of type {@link DataType#DOUBLE}.
     */
    public static NDArray buildFromTensorDouble(Tensor<Double> tensor, NDManager manager)
    {
		long[] tensorShape = tensor.shape();
		int totalSize = 1;
		for (long i : tensorShape) {totalSize *= i;}
		double[] flatImageArray = new double[totalSize];
		DoubleBuffer outBuff = DoubleBuffer.wrap(flatImageArray);
	 	tensor.writeTo(outBuff);
	 	NDArray ndarray = manager.create(flatImageArray, new Shape(tensorShape));
	 	return ndarray;
    }
}
