package infixtoprefix;

public class AcoesSemanticas extends infixtoposfixBaseListener {

	String expre = "";
	public String output = "";
	InfixToPostfix theTrans;

	public void enterFator(infixtoposfixParser.FatorContext ctx) {
		if (ctx.NEWLINE() != null) {
			//System.out.println("Expressão " + expre);
			theTrans = new InfixToPostfix(100);
			output = theTrans.InToPost(expre);
			//System.out.println(output);
			expre = "";
		}
	}
	
	public void enterExpr(infixtoposfixParser.ExprContext ctx) {
		  if (ctx.fator().INT() != null)
			  expre+=ctx.start.getText(); 
		  if (ctx.fator().ID() != null) 
			  expre+=ctx.start.getText(); 
		  if (ctx.op != null) 
			  expre+=ctx.op.getText();
	}

}