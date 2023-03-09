package org.python.modules.jffi;

import com.kenai.jffi.CallingConvention;
import java.util.Arrays;

public final class JITSignature {
    private final NativeType resultType;
    private final NativeType[] parameterTypes;
    private final boolean hasResultConverter;
    private final boolean[] hasParameterConverter;
    private final CallingConvention convention;
    private final boolean ignoreError;

    public JITSignature(NativeType resultType, NativeType[] parameterTypes,
                        boolean hasResultConverter, boolean[] hasParameterConverter,
                        CallingConvention convention, boolean ignoreError) {
        this.resultType = resultType;
        this.parameterTypes = (NativeType[]) parameterTypes.clone();
        this.convention = convention;
        this.ignoreError = ignoreError;
        this.hasResultConverter = hasResultConverter;
        this.hasParameterConverter = (boolean[]) hasParameterConverter.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(getClass())) {
            return false;
        }
        JITSignature rhs = (JITSignature) o;
        return resultType.equals(rhs.resultType) && convention.equals(rhs.convention)
                && ignoreError == rhs.ignoreError
                && Arrays.equals(parameterTypes, rhs.parameterTypes)
                && hasResultConverter == rhs.hasResultConverter
                && Arrays.equals(hasParameterConverter, rhs.hasParameterConverter);
                
    }

    @Override
    public int hashCode() {
        return resultType.hashCode() 
                ^ convention.hashCode() 
                ^ Boolean.valueOf(ignoreError).hashCode()
                ^ Arrays.hashCode(parameterTypes)
                ^ Boolean.valueOf(hasResultConverter).hashCode()
                ^ Arrays.hashCode(hasParameterConverter);
    }

    public final NativeType getResultType() {
        return resultType;
    }

    public final NativeType getParameterType(int parameterIndex) {
        return parameterTypes[parameterIndex];
    }
    
    public final CallingConvention getCallingConvention() {
        return convention;
    }
    
    public final int getParameterCount() {
        return parameterTypes.length;
    }
    
    public final boolean hasResultConverter() {
        return hasResultConverter;
    }
    
    public final boolean hasParameterConverter(int parameterIndex) {
        return hasParameterConverter[parameterIndex];
    }

    public boolean isIgnoreError() {
        return ignoreError;
    }
    
}
