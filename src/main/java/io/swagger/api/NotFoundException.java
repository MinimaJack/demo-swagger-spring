package io.swagger.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-10-31T05:31:33.705Z[GMT]")
public class NotFoundException
    extends ApiException
{
    private int code;

    public NotFoundException( int code, String msg )
    {
        super( code, msg );
        this.code = code;
    }
}
