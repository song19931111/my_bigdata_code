// Generated from E:/songxiang/code/bigdata/antlr/src/main/java/cal\Cal.g4 by ANTLR 4.7
package cal;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, MUL=6, DIV=7, ADD=8, SUB=9, ID=10, 
		NUM=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "MUL", "DIV", "ADD", "SUB", "ID", 
		"NUM", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "';'", "'print'", "'('", "')'", "'*'", "'/'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "MUL", "DIV", "ADD", "SUB", "ID", 
		"NUM", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16d\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\7\13\64\n\13\f\13\16"+
		"\13\67\13\13\3\f\6\f:\n\f\r\f\16\f;\3\f\3\f\3\f\6\fA\n\f\r\f\16\fB\3\f"+
		"\3\f\6\fG\n\f\r\f\16\fH\3\f\3\f\6\fM\n\f\r\f\16\fN\3\f\3\f\3\f\6\fT\n"+
		"\f\r\f\16\fU\3\f\3\f\6\fZ\n\f\r\f\16\f[\3\f\5\f_\n\f\3\r\3\r\3\r\3\r\2"+
		"\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\6\4"+
		"\2C\\c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2m\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2"+
		"\2\2\5\35\3\2\2\2\7\37\3\2\2\2\t%\3\2\2\2\13\'\3\2\2\2\r)\3\2\2\2\17+"+
		"\3\2\2\2\21-\3\2\2\2\23/\3\2\2\2\25\61\3\2\2\2\27^\3\2\2\2\31`\3\2\2\2"+
		"\33\34\7?\2\2\34\4\3\2\2\2\35\36\7=\2\2\36\6\3\2\2\2\37 \7r\2\2 !\7t\2"+
		"\2!\"\7k\2\2\"#\7p\2\2#$\7v\2\2$\b\3\2\2\2%&\7*\2\2&\n\3\2\2\2\'(\7+\2"+
		"\2(\f\3\2\2\2)*\7,\2\2*\16\3\2\2\2+,\7\61\2\2,\20\3\2\2\2-.\7-\2\2.\22"+
		"\3\2\2\2/\60\7/\2\2\60\24\3\2\2\2\61\65\t\2\2\2\62\64\t\3\2\2\63\62\3"+
		"\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\26\3\2\2\2\67\65\3"+
		"\2\2\28:\t\4\2\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<_\3\2\2\2=>\7"+
		"*\2\2>@\7/\2\2?A\t\4\2\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2\2CD\3\2"+
		"\2\2D_\7+\2\2EG\t\4\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2IJ\3\2"+
		"\2\2JL\7\60\2\2KM\t\4\2\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2O_\3"+
		"\2\2\2PQ\7*\2\2QS\7/\2\2RT\t\4\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2"+
		"\2\2VW\3\2\2\2WY\7\60\2\2XZ\t\4\2\2YX\3\2\2\2Z[\3\2\2\2[Y\3\2\2\2[\\\3"+
		"\2\2\2\\]\3\2\2\2]_\7+\2\2^9\3\2\2\2^=\3\2\2\2^F\3\2\2\2^P\3\2\2\2_\30"+
		"\3\2\2\2`a\t\5\2\2ab\3\2\2\2bc\b\r\2\2c\32\3\2\2\2\13\2\65;BHNU[^\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}