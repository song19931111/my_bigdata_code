// Generated from E:/songxiang/code/bigdata/antlr/src/main/java/cal\Cal.g4 by ANTLR 4.7
package cal;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalParser}.
 */
public interface CalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CalParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CalParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link CalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(CalParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link CalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(CalParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link CalParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(CalParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link CalParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(CalParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link CalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(CalParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link CalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(CalParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link CalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(CalParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link CalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(CalParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link CalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(CalParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link CalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(CalParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NUM}
	 * labeled alternative in {@link CalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNUM(CalParser.NUMContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NUM}
	 * labeled alternative in {@link CalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNUM(CalParser.NUMContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ID}
	 * labeled alternative in {@link CalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterID(CalParser.IDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link CalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitID(CalParser.IDContext ctx);
}