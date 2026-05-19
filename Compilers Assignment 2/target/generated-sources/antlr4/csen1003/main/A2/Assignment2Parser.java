// Generated from csen1003/main/A2/Assignment2.g4 by ANTLR 4.13.1
package csen1003.main.A2;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class Assignment2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, NUM=2, WS=3;
	public static final int
		RULE_s = 0, RULE_seq = 1, RULE_tail = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"s", "seq", "tail"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "NUM", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	@Override
	public String getGrammarFileName() { return "Assignment2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Assignment2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SContext extends ParserRuleContext {
		public int check;
		public SeqContext seq;
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Assignment2Listener ) ((Assignment2Listener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Assignment2Listener ) ((Assignment2Listener)listener).exitS(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			setState(10);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				((SContext)_localctx).seq = seq();
				 ((SContext)_localctx).check =  ((SContext)_localctx).seq.check; 
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				 ((SContext)_localctx).check =  1; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeqContext extends ParserRuleContext {
		public int check;
		public Token n;
		public TailContext rest;
		public TerminalNode NUM() { return getToken(Assignment2Parser.NUM, 0); }
		public TailContext tail() {
			return getRuleContext(TailContext.class,0);
		}
		public SeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Assignment2Listener ) ((Assignment2Listener)listener).enterSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Assignment2Listener ) ((Assignment2Listener)listener).exitSeq(this);
		}
	}

	public final SeqContext seq() throws RecognitionException {
		SeqContext _localctx = new SeqContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_seq);
		try {
			setState(19);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(12);
				((SeqContext)_localctx).n = match(NUM);
				 ((SeqContext)_localctx).check =  1; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(14);
				((SeqContext)_localctx).n = match(NUM);
				setState(15);
				match(T__0);
				setState(16);
				((SeqContext)_localctx).rest = tail(Integer.parseInt((((SeqContext)_localctx).n!=null?((SeqContext)_localctx).n.getText():null)));
				 ((SeqContext)_localctx).check =  ((SeqContext)_localctx).rest.check; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TailContext extends ParserRuleContext {
		public int prev;
		public int check;
		public int first;
		public Token n;
		public TailContext rest;
		public TerminalNode NUM() { return getToken(Assignment2Parser.NUM, 0); }
		public TailContext tail() {
			return getRuleContext(TailContext.class,0);
		}
		public TailContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TailContext(ParserRuleContext parent, int invokingState, int prev) {
			super(parent, invokingState);
			this.prev = prev;
		}
		@Override public int getRuleIndex() { return RULE_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Assignment2Listener ) ((Assignment2Listener)listener).enterTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Assignment2Listener ) ((Assignment2Listener)listener).exitTail(this);
		}
	}

	public final TailContext tail(int prev) throws RecognitionException {
		TailContext _localctx = new TailContext(_ctx, getState(), prev);
		enterRule(_localctx, 4, RULE_tail);
		try {
			setState(28);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				((TailContext)_localctx).n = match(NUM);

				        ((TailContext)_localctx).check =  1;
				        ((TailContext)_localctx).first =  Integer.parseInt((((TailContext)_localctx).n!=null?((TailContext)_localctx).n.getText():null));
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				((TailContext)_localctx).n = match(NUM);
				setState(24);
				match(T__0);
				setState(25);
				((TailContext)_localctx).rest = tail(Integer.parseInt((((TailContext)_localctx).n!=null?((TailContext)_localctx).n.getText():null)));

				        int cur = Integer.parseInt((((TailContext)_localctx).n!=null?((TailContext)_localctx).n.getText():null));
				        // cur is a strict local max/min iff (cur-prev) and (cur-next) share a sign
				        ((TailContext)_localctx).check =  ((cur - _localctx.prev) * (cur - ((TailContext)_localctx).rest.first) > 0) ? ((TailContext)_localctx).rest.check : 0;
				        ((TailContext)_localctx).first =  cur;
				      
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0003\u001f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u0000\u000b\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0014\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002\u001d\b\u0002\u0001\u0002\u0000\u0000\u0003\u0000\u0002\u0004"+
		"\u0000\u0000\u001e\u0000\n\u0001\u0000\u0000\u0000\u0002\u0013\u0001\u0000"+
		"\u0000\u0000\u0004\u001c\u0001\u0000\u0000\u0000\u0006\u0007\u0003\u0002"+
		"\u0001\u0000\u0007\b\u0006\u0000\uffff\uffff\u0000\b\u000b\u0001\u0000"+
		"\u0000\u0000\t\u000b\u0006\u0000\uffff\uffff\u0000\n\u0006\u0001\u0000"+
		"\u0000\u0000\n\t\u0001\u0000\u0000\u0000\u000b\u0001\u0001\u0000\u0000"+
		"\u0000\f\r\u0005\u0002\u0000\u0000\r\u0014\u0006\u0001\uffff\uffff\u0000"+
		"\u000e\u000f\u0005\u0002\u0000\u0000\u000f\u0010\u0005\u0001\u0000\u0000"+
		"\u0010\u0011\u0003\u0004\u0002\u0000\u0011\u0012\u0006\u0001\uffff\uffff"+
		"\u0000\u0012\u0014\u0001\u0000\u0000\u0000\u0013\f\u0001\u0000\u0000\u0000"+
		"\u0013\u000e\u0001\u0000\u0000\u0000\u0014\u0003\u0001\u0000\u0000\u0000"+
		"\u0015\u0016\u0005\u0002\u0000\u0000\u0016\u001d\u0006\u0002\uffff\uffff"+
		"\u0000\u0017\u0018\u0005\u0002\u0000\u0000\u0018\u0019\u0005\u0001\u0000"+
		"\u0000\u0019\u001a\u0003\u0004\u0002\u0000\u001a\u001b\u0006\u0002\uffff"+
		"\uffff\u0000\u001b\u001d\u0001\u0000\u0000\u0000\u001c\u0015\u0001\u0000"+
		"\u0000\u0000\u001c\u0017\u0001\u0000\u0000\u0000\u001d\u0005\u0001\u0000"+
		"\u0000\u0000\u0003\n\u0013\u001c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}