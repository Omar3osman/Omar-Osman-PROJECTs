// Generated from csen1003/main/A2/Assignment2.g4 by ANTLR 4.13.1
package csen1003.main.A2;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Assignment2Parser}.
 */
public interface Assignment2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Assignment2Parser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(Assignment2Parser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link Assignment2Parser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(Assignment2Parser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link Assignment2Parser#seq}.
	 * @param ctx the parse tree
	 */
	void enterSeq(Assignment2Parser.SeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link Assignment2Parser#seq}.
	 * @param ctx the parse tree
	 */
	void exitSeq(Assignment2Parser.SeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link Assignment2Parser#tail}.
	 * @param ctx the parse tree
	 */
	void enterTail(Assignment2Parser.TailContext ctx);
	/**
	 * Exit a parse tree produced by {@link Assignment2Parser#tail}.
	 * @param ctx the parse tree
	 */
	void exitTail(Assignment2Parser.TailContext ctx);
}