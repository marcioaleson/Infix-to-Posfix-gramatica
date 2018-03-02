package infixtoprefix;

// Generated from infixtoposfix.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link infixtoposfixParser}.
 */
public interface infixtoposfixListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link infixtoposfixParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(infixtoposfixParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link infixtoposfixParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(infixtoposfixParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link infixtoposfixParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(infixtoposfixParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link infixtoposfixParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(infixtoposfixParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link infixtoposfixParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(infixtoposfixParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link infixtoposfixParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(infixtoposfixParser.FatorContext ctx);
}