package io.swagger.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-10-31T05:31:33.705Z[GMT]")
public class ApiException
    extends Exception
{
    private int code;

    public ApiException( int code, String msg )
    {
        super( msg );
        this.code = code;
    }
}
