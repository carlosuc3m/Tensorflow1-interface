package org.bioimageanalysis.icy.tensorflow.v1.tensor;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.tensorflow.Tensor;
import org.tensorflow.types.UInt8;

import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.types.DataType;

/**
 * A TensorFlow {@link Tensor} builder for {@link NDArray} objects.
 * 
 * @author Carlos Garcia Lopez de Haro
 */
public final class TensorBuilder
{

    /**
     * Not used (Utility class).
     */
    private TensorBuilder()
    {
    }

    /**
     * Creates a {@link Tensor} based on the provided {@link Sequence} and the desired dimension order for the resulting tensor.
     * 
     * @param ndarray
     *        The NDArray to be converted.
     * @param tensorDimOrder
     *        The resulting tensor dimension order. e.g. [2,0,1] = the first tensor axis with be associated to the channel dimension of the sequence (2), the
     *        second axis to the x dimension of the sequence (0), and the third tensor axis will be associated to the y dimension of the sequence (1).
     * @return The tensor created from the sequence.
     * @throws IllegalArgumentException
     *         If the ndarray type is not supported.
     */
    public static Tensor<?> build(NDArray ndarray)
    {
        switch (ndarray.getDataType())
        {
            case INT8:
            case UINT8:
                return buildByte(ndarray);
            case INT32:
                return buildInt(ndarray);
            case FLOAT32:
                return buildFloat(ndarray);
            case FLOAT64:
                return buildDouble(ndarray);
            default:
                throw new IllegalArgumentException("The image has an unsupported type: " + ndarray.getDataType().toString());
        }
    }

    /**
     * Creates a unsigned byte-typed {@link Tensor} based on the provided {@link Sequence} and the desired dimension order for the resulting tensor.
     * 
     * @param ndarray
     *        The sequence to be converted.
     * @param tensorDimOrder
     *        The resulting tensor dimension order. e.g. [2,0,1] = the first tensor axis with be associated to the channel dimension of the sequence (2), the
     *        second axis to the x dimension of the sequence (0), and the third tensor axis will be associated to the y dimension of the sequence (1).
     * @return The tensor created from the sequence.
     * @throws IllegalArgumentException
     *         If the ndarray type is not supported.
     */
    public static Tensor<UInt8> buildByte(NDArray ndarray)
    {
        if (ndarray.getDataType() != DataType.INT8 && ndarray.getDataType() != DataType.UINT8)
            throw new IllegalArgumentException("Image is not of byte type: " + ndarray.getDataType().toString());

        ByteBuffer outBuff = ByteBuffer.wrap(ndarray.toByteArray());
		Tensor<UInt8> tensor = Tensor.create(UInt8.class, ndarray.getShape().getShape(), outBuff);
		return tensor;
    }

    /**
     * Creates a integer-typed {@link Tensor} based on the provided {@link Sequence} and the desired dimension order for the resulting tensor.
     * 
     * @param ndarray
     *        The sequence to be converted.
     * @param tensorDimOrder
     *        The resulting tensor dimension order. e.g. [2,0,1] = the first tensor axis with be associated to the channel dimension of the sequence (2), the
     *        second axis to the x dimension of the sequence (0), and the third tensor axis will be associated to the y dimension of the sequence (1).
     * @return The tensor created from the sequence.
     * @throws IllegalArgumentException
     *         If the ndarray type is not supported.
     */
    public static Tensor<Integer> buildInt(NDArray ndarray)
    {
        if (ndarray.getDataType() != DataType.INT32)
            throw new IllegalArgumentException("Image is not of int type: " + ndarray.getDataType().toString());

        IntBuffer outBuff = IntBuffer.wrap(ndarray.toIntArray());
		Tensor<Integer> tensor = Tensor.create(ndarray.getShape().getShape(), outBuff);
		return tensor;
    }

    /**
     * Creates a float-typed {@link Tensor} based on the provided {@link Sequence} and the desired dimension order for the resulting tensor.
     * 
     * @param ndarray
     *        The sequence to be converted.
     * @param tensorDimOrder
     *        The resulting tensor dimension order. e.g. [2,0,1] = the first tensor axis with be associated to the channel dimension of the sequence (2), the
     *        second axis to the x dimension of the sequence (0), and the third tensor axis will be associated to the y dimension of the sequence (1).
     * @return The tensor created from the sequence.
     * @throws IllegalArgumentException
     *         If the ndarray type is not supported.
     */
    public static Tensor<Float> buildFloat(NDArray ndarray)
    {
        if (ndarray.getDataType() != DataType.FLOAT32)
            throw new IllegalArgumentException("Image is not of float type: " + ndarray.getDataType().toString());

        FloatBuffer outBuff = FloatBuffer.wrap(ndarray.toFloatArray());
		Tensor<Float> tensor = Tensor.create(ndarray.getShape().getShape(), outBuff);
		return tensor;
    }

    /**
     * Creates a double-typed {@link Tensor} based on the provided {@link Sequence} and the desired dimension order for the resulting tensor.
     * 
     * @param ndarray
     *        The ndarray to be converted.
     * @param tensorDimOrder
     *        The resulting tensor dimension order. e.g. [2,0,1] = the first tensor axis with be associated to the channel dimension of the sequence (2), the
     *        second axis to the x dimension of the sequence (0), and the third tensor axis will be associated to the y dimension of the sequence (1).
     * @return The tensor created from the sequence.
     * @throws IllegalArgumentException
     *         If the ndarray type is not supported.
     */
    public static Tensor<Double> buildDouble(NDArray ndarray)
    {
        if (ndarray.getDataType() != DataType.FLOAT64)
            throw new IllegalArgumentException("Image is not of float type: " + ndarray.getDataType().toString());

		DoubleBuffer outBuff = DoubleBuffer.wrap(ndarray.toDoubleArray());
		Tensor<Double> tensor = Tensor.create(ndarray.getShape().getShape(), outBuff);
		return tensor;
    }
}
