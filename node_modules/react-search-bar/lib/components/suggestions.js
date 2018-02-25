'use strict';

Object.defineProperty(exports, "__esModule", {
  value: true
});

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

var _react = require('react');

var _react2 = _interopRequireDefault(_react);

var _propTypes = require('prop-types');

var _propTypes2 = _interopRequireDefault(_propTypes);

var _classnames = require('classnames');

var _classnames2 = _interopRequireDefault(_classnames);

var _reactAutobind = require('react-autobind');

var _reactAutobind2 = _interopRequireDefault(_reactAutobind);

var _suggestion = require('./suggestion');

var _suggestion2 = _interopRequireDefault(_suggestion);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var Suggestions = function (_React$Component) {
  _inherits(Suggestions, _React$Component);

  function Suggestions(props) {
    _classCallCheck(this, Suggestions);

    var _this = _possibleConstructorReturn(this, (Suggestions.__proto__ || Object.getPrototypeOf(Suggestions)).call(this, props));

    (0, _reactAutobind2.default)(_this);
    return _this;
  }

  _createClass(Suggestions, [{
    key: 'componentDidUpdate',
    value: function componentDidUpdate() {
      this.scrollToSuggestion();
    }
  }, {
    key: 'scrollToSuggestion',
    value: function scrollToSuggestion() {
      if (this.props.focusedSuggestion === null) {
        this.list.scrollTop = 0;
        return;
      }

      var focusedSuggestion = this.focusedSuggestion,
          list = this.list;

      var listRect = list.getBoundingClientRect();
      var suggestionRect = focusedSuggestion.getBoundingClientRect();

      if (suggestionRect.bottom > listRect.bottom) {
        list.scrollTop = focusedSuggestion.offsetTop + focusedSuggestion.clientHeight - list.clientHeight;
      } else if (suggestionRect.top < listRect.top) {
        list.scrollTop = focusedSuggestion.offsetTop;
      }
    }
  }, {
    key: 'setFocusedSuggestion',
    value: function setFocusedSuggestion(ref) {
      this.focusedSuggestion = ref && ref.item;
    }
  }, {
    key: 'handleMouseMove',
    value: function handleMouseMove(event, index) {
      var _event$nativeEvent = event.nativeEvent,
          movementX = _event$nativeEvent.movementX,
          movementY = _event$nativeEvent.movementY;


      if (movementX || movementY) {
        this.props.onSuggestionHover(index);
      }
    }
  }, {
    key: 'handleMouseLeave',
    value: function handleMouseLeave() {
      this.props.onSuggestionHover(null);
    }
  }, {
    key: 'renderSuggestion',
    value: function renderSuggestion(suggestion, index) {
      var _classNames;

      var props = this.props;

      var isFocused = props.focusedSuggestion === index;

      return _react2.default.createElement(_suggestion2.default, {
        className: (0, _classnames2.default)((_classNames = {}, _defineProperty(_classNames, props.styles.suggestion, true), _defineProperty(_classNames, props.styles.suggestionFocused, isFocused), _classNames)),
        index: index,
        key: suggestion,
        onClick: props.onSelection,
        onMouseMove: this.handleMouseMove,
        ref: isFocused && this.setFocusedSuggestion,
        searchTerm: props.searchTerm,
        suggestion: suggestion,
        suggestionRenderer: props.suggestionRenderer
      });
    }
  }, {
    key: 'render',
    value: function render() {
      var _this2 = this;

      return _react2.default.createElement(
        'ul',
        {
          className: this.props.styles.suggestions,
          ref: function ref(_ref) {
            return _this2.list = _ref;
          },
          onMouseLeave: this.handleMouseLeave
        },
        this.props.suggestions.map(this.renderSuggestion)
      );
    }
  }]);

  return Suggestions;
}(_react2.default.Component);

Suggestions.defaultProps = {
  styles: {
    suggestions: 'react-search-bar__suggestions',
    suggestion: 'react-search-bar__suggestion',
    focusedSuggestion: 'react-search-bar__suggestion--focused'
  }
};

Suggestions.propTypes = {
  focusedSuggestion: _propTypes2.default.number,
  onSelection: _propTypes2.default.func.isRequired,
  onSuggestionHover: _propTypes2.default.func.isRequired,
  searchTerm: _propTypes2.default.string.isRequired,
  styles: _propTypes2.default.object,
  suggestions: _propTypes2.default.array.isRequired
};

exports.default = Suggestions;