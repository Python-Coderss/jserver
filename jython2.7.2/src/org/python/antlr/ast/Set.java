// Autogenerated AST node
package org.python.antlr.ast;

import org.antlr.runtime.Token;
import org.python.antlr.PythonTree;
import org.python.antlr.adapter.AstAdapters;
import org.python.antlr.base.expr;
import org.python.core.ArgParser;
import org.python.core.AstList;
import org.python.core.Py;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PyStringMap;
import org.python.core.PyType;
import org.python.expose.ExposedGet;
import org.python.expose.ExposedMethod;
import org.python.expose.ExposedNew;
import org.python.expose.ExposedSet;
import org.python.expose.ExposedType;
import java.util.ArrayList;

@ExposedType(name = "_ast.Set", base = expr.class)
public class Set extends expr {
public static final PyType TYPE = PyType.fromClass(Set.class);
    private java.util.List<expr> elts;
    public java.util.List<expr> getInternalElts() {
        return elts;
    }
    @ExposedGet(name = "elts")
    public PyObject getElts() {
        return new AstList(elts, AstAdapters.exprAdapter);
    }
    @ExposedSet(name = "elts")
    public void setElts(PyObject elts) {
        this.elts = AstAdapters.py2exprList(elts);
    }


    private final static PyString[] fields =
    new PyString[] {new PyString("elts")};
    @ExposedGet(name = "_fields")
    public PyString[] get_fields() { return fields; }

    private final static PyString[] attributes =
    new PyString[] {new PyString("lineno"), new PyString("col_offset")};
    @ExposedGet(name = "_attributes")
    public PyString[] get_attributes() { return attributes; }

    public Set(PyType subType) {
        super(subType);
    }
    public Set() {
        this(TYPE);
    }
    @ExposedNew
    @ExposedMethod
    public void Set___init__(PyObject[] args, String[] keywords) {
        ArgParser ap = new ArgParser("Set", args, keywords, new String[]
            {"elts", "lineno", "col_offset"}, 1, true);
        setElts(ap.getPyObject(0, Py.None));
        int lin = ap.getInt(1, -1);
        if (lin != -1) {
            setLineno(lin);
        }

        int col = ap.getInt(2, -1);
        if (col != -1) {
            setLineno(col);
        }

    }

    public Set(PyObject elts) {
        setElts(elts);
    }

    public Set(Token token, java.util.List<expr> elts) {
        super(token);
        this.elts = elts;
        if (elts == null) {
            this.elts = new ArrayList<expr>();
        }
        for(PythonTree t : this.elts) {
            addChild(t);
        }
    }

    public Set(Integer ttype, Token token, java.util.List<expr> elts) {
        super(ttype, token);
        this.elts = elts;
        if (elts == null) {
            this.elts = new ArrayList<expr>();
        }
        for(PythonTree t : this.elts) {
            addChild(t);
        }
    }

    public Set(PythonTree tree, java.util.List<expr> elts) {
        super(tree);
        this.elts = elts;
        if (elts == null) {
            this.elts = new ArrayList<expr>();
        }
        for(PythonTree t : this.elts) {
            addChild(t);
        }
    }

    @ExposedGet(name = "repr")
    public String toString() {
        return "Set";
    }

    public String toStringTree() {
        StringBuffer sb = new StringBuffer("Set(");
        sb.append("elts=");
        sb.append(dumpThis(elts));
        sb.append(",");
        sb.append(")");
        return sb.toString();
    }

    public <R> R accept(VisitorIF<R> visitor) throws Exception {
        return visitor.visitSet(this);
    }

    public void traverse(VisitorIF<?> visitor) throws Exception {
        if (elts != null) {
            for (PythonTree t : elts) {
                if (t != null)
                    t.accept(visitor);
            }
        }
    }

    public PyObject __dict__;

    @Override
    public PyObject fastGetDict() {
        ensureDict();
        return __dict__;
    }

    @ExposedGet(name = "__dict__")
    public PyObject getDict() {
        return fastGetDict();
    }

    private void ensureDict() {
        if (__dict__ == null) {
            __dict__ = new PyStringMap();
        }
    }

    private int lineno = -1;
    @ExposedGet(name = "lineno")
    public int getLineno() {
        if (lineno != -1) {
            return lineno;
        }
        return getLine();
    }

    @ExposedSet(name = "lineno")
    public void setLineno(int num) {
        lineno = num;
    }

    private int col_offset = -1;
    @ExposedGet(name = "col_offset")
    public int getCol_offset() {
        if (col_offset != -1) {
            return col_offset;
        }
        return getCharPositionInLine();
    }

    @ExposedSet(name = "col_offset")
    public void setCol_offset(int num) {
        col_offset = num;
    }

}