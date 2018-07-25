package cal;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/23
 */
import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends CalBaseVisitor<Double> {
    private Map<String,Double> table;

    public EvalVisitor(){
        table=new HashMap<>();
    }

    @Override
    public Double visitPrintExpr(CalParser.PrintExprContext ctx) {
        Double value=visit(ctx.expr());
        String str=value.toString();
        int index=str.indexOf('.');
        //check if it is an integer
        if(str.substring(index+1).equals("0"))
            System.out.println(str.substring(0,index));
        else
            System.out.println(str);
        return null;
    }

    @Override
    public Double visitAssign(CalParser.AssignContext ctx) {
        String id=ctx.ID().getText();
        Double value=visit(ctx.expr());
        table.put(id,value);
        return null;
    }

    @Override
    public Double visitMulDiv(CalParser.MulDivContext ctx) {
        Double left=visit(ctx.expr(0));
        Double right=visit(ctx.expr(1));
        //if divided by zero,get the position of zero
        int line,column;
        if(ctx.op.getType()==CalParser.DIV){
            if(right==0.0){
                line=ctx.expr(1).start.getLine();
                column=ctx.expr(1).start.getStartIndex();
                try{
                    throw new CalException(line,column,"Divided by zero");
                }catch (CalException e){
                    System.out.println(e.toString());
                }
                return null;
            }else
                return left/right;
        }else
            return left*right;
    }

    @Override
    public Double visitAddSub(CalParser.AddSubContext ctx) {
        Double left=visit(ctx.expr(0));
        Double right=visit(ctx.expr(1));
        if(ctx.op.getType()==CalParser.ADD)
            return left+right;
        else
            return left-right;
    }

    @Override
    public Double visitNUM(CalParser.NUMContext ctx) {
        return Double.valueOf(ctx.getText());
    }

    @Override
    public Double visitID(CalParser.IDContext ctx) {
        String id=ctx.getText();
        int line,column;
        if(table.containsKey(id))
            return table.get(id);
        else{
            line=ctx.start.getLine();
            column=ctx.start.getStartIndex();
            try{
                throw new CalException(line,column,"Undefined variable:"+id);
            }catch (CalException e){
                System.out.println(e.toString());
            }
            return null;
        }
    }

    @Override
    public Double visitParens(CalParser.ParensContext ctx) {
        return visit(ctx.expr());
    }
}