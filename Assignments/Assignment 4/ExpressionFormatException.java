/**
 * Indicates that an expression contains invalid tokens for the requested operation.
 */
public class ExpressionFormatException
	extends java.lang.Exception
{
	public ExpressionFormatException(String message) {
		super(message);
	}
}
