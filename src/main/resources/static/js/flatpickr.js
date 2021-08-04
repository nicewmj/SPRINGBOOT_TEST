function Flatpickr(e, t) {
    function n() {
        K.element = e,
            K.instanceConfig = t || {},
            j(),
            M(),
            S(),
            F(),
            Y(),
            K.changeMonth = p,
            K.clear = f,
            K.close = m,
            K.destroy = g,
            K.formatDate = v,
            K.jumpToDate = i,
            K.open = w,
            K.parseDate = E,
            K.redraw = T,
            K.set = O,
            K.setDate = x,
            K.toggle = H,
            K.isMobile = !K.config.disableMobile && /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent),
            K.isMobile ? (r(), N()) : (o(), r()),
        K.selectedDateObj && P(),
            _("Ready")
    }

    function a(e) {
        z(e),
            P(e)
    }

    function r() {
        K.config.wrap && ["open", "close", "toggle", "clear"].forEach(function (e) {
            try {
                K.element.querySelector("[data-" + e + "]").addEventListener("click", K[e])
            } catch (e) {
            }
        }),
        K.isMobile || (document.addEventListener("keydown", y), window.addEventListener("resize", B(C, 300)), document.addEventListener("click", h), document.addEventListener("blur", h), K.config.clickOpens && (K.altInput || K.input).addEventListener("focus", w), K.config.noCalendar || (K.prevMonthNav.addEventListener("click",
            function () {
                return p(-1)
            }), K.nextMonthNav.addEventListener("click",
            function () {
                return p(1)
            }), K.currentYearElement.addEventListener("wheel", U), K.currentYearElement.addEventListener("focus",
            function () {
                K.currentYearElement.select()
            }), K.currentYearElement.addEventListener("input",
            function (e) {
                4 === e.target.value.length && K.currentYearElement.blur(),
                    K.currentYear = parseInt(e.target.value, 10) || K.currentYear,
                    K.redraw()
            }), K.days.addEventListener("click", L)), K.config.enableTime && (K.timeContainer.addEventListener("wheel", a), K.timeContainer.addEventListener("wheel", B(function () {
                return _("Change")
            },
            1e3)), K.timeContainer.addEventListener("input", a), K.hourElement.addEventListener("focus",
            function () {
                K.hourElement.select()
            }), K.minuteElement.addEventListener("focus",
            function () {
                K.minuteElement.select()
            }), K.secondElement && K.secondElement.addEventListener("focus",
            function () {
                K.secondElement.select()
            }), K.amPM && K.amPM.addEventListener("click", a)))
    }

    function i(e) {
        e = e ? E(e) : K.selectedDateObj || K.config.defaultDate || K.config.minDate || K.now,
            K.currentYear = e.getFullYear(),
            K.currentMonth = e.getMonth(),
            K.redraw()
    }

    function o() {
        var e = document.createDocumentFragment();
        K.calendarContainer = W("div", "flatpickr-calendar"),
        K.config.noCalendar || (e.appendChild(c()), K.config.weekNumbers && e.appendChild(d()), K.rContainer = W("div", "flatpickr-rContainer"), K.rContainer.appendChild(s()), K.rContainer.appendChild(l()), e.appendChild(K.rContainer)),
        K.config.enableTime && e.appendChild(u()),
            K.calendarContainer.appendChild(e),
            K.config.inline || K.config.static ? (K.calendarContainer.classList.add(K.config.inline ? "inline" : "static"), I(), K.element.parentNode.appendChild(K.calendarContainer)) : document.body.appendChild(K.calendarContainer)
    }

    function l() {
        K.days || (K.days = W("div", "flatpickr-days"), K.days.tabIndex = -1);
        var e = (new Date(K.currentYear, K.currentMonth, 1).getDay() - Flatpickr.l10n.firstDayOfWeek + 7) % 7,
            t = K.utils.getDaysinMonth(),
            n = K.utils.getDaysinMonth((K.currentMonth - 1 + 12) % 12),
            a = document.createDocumentFragment(),
            r = n + 1 - e,
            i = void 0,
            o = void 0;
        for (K.config.weekNumbers && (K.weekNumbers.innerHTML = ""), K.days.innerHTML = ""; r <= n; r++) {
            var l = new Date(K.currentYear, K.currentMonth - 1, r, 0, 0, 0, 0, 0),
                c = k(l),
                u = W("span", "flatpickr-day prevMonthDay" + (c ? "" : " disabled"), r);
            c && (u.tabIndex = 0),
                a.appendChild(u)
        }
        for (r = 1; r <= t; r++) {
            i = new Date(K.currentYear, K.currentMonth, r, 0, 0, 0, 0, 0),
            K.config.weekNumbers && r % 7 === 1 && K.weekNumbers.insertAdjacentHTML("beforeend", "<span class='disabled flatpickr-day'>" + K.getWeek(i) + "</span>"),
                o = !k(i);
            var s = W("span", o ? "flatpickr-day disabled" : "flatpickr-day", r);
            o || (s.tabIndex = 0, J(i, new Date) && s.classList.add("today"), K.selectedDateObj && J(i, K.selectedDateObj) && (s.classList.add("selected"), K.selectedDateElem = s)),
                a.appendChild(s)
        }
        for (var d = t + 1; d <= 42 - e; d++) {
            var p = new Date(K.currentYear, K.currentMonth + 1, d % t, 0, 0, 0, 0, 0),
                f = k(p),
                m = W("span", "flatpickr-day nextMonthDay" + (f ? "" : " disabled"), d % t);
            K.config.weekNumbers && d % 7 === 1 && K.weekNumbers.insertAdjacentHTML("beforeend", "<span class='disabled flatpickr-day'>" + K.getWeek(p) + "</span>"),
            f && (m.tabIndex = 0),
                a.appendChild(m)
        }
        return K.days.appendChild(a),
            K.days
    }

    function c() {
        var e = document.createDocumentFragment();
        return K.monthNav = W("div", "flatpickr-month"),
            K.prevMonthNav = W("span", "flatpickr-prev-month"),
            K.prevMonthNav.innerHTML = K.config.prevArrow,
            K.currentMonthElement = W("span", "cur_month"),
            K.currentYearElement = W("input", "cur_year"),
            K.currentYearElement.type = "number",
            K.currentYearElement.title = Flatpickr.l10n.scrollTitle,
            K.nextMonthNav = W("span", "flatpickr-next-month"),
            K.nextMonthNav.innerHTML = K.config.nextArrow,
            K.navigationCurrentMonth = W("span", "flatpickr-current-month"),
            K.navigationCurrentMonth.appendChild(K.currentMonthElement),
            K.navigationCurrentMonth.appendChild(K.currentYearElement),
            e.appendChild(K.prevMonthNav),
            e.appendChild(K.navigationCurrentMonth),
            e.appendChild(K.nextMonthNav),
            K.monthNav.appendChild(e),
            A(),
            K.monthNav
    }

    function u() {
        K.calendarContainer.classList.add("hasTime"),
            K.timeContainer = W("div", "flatpickr-time"),
            K.timeContainer.tabIndex = -1;
        var e = W("span", "flatpickr-time-separator", ":");
        return K.hourElement = W("input", "flatpickr-hour"),
            K.minuteElement = W("input", "flatpickr-minute"),
            K.hourElement.tabIndex = K.minuteElement.tabIndex = 0,
            K.hourElement.type = K.minuteElement.type = "number",
            K.hourElement.value = K.selectedDateObj ? D(K.selectedDateObj.getHours()) : 12,
            K.minuteElement.value = K.selectedDateObj ? D(K.selectedDateObj.getMinutes()) : "00",
            K.hourElement.step = K.config.hourIncrement,
            K.minuteElement.step = K.config.minuteIncrement,
            K.hourElement.min = -(K.config.time_24hr ? 1 : 0),
            K.hourElement.max = K.config.time_24hr ? 24 : 13,
            K.minuteElement.min = -K.minuteElement.step,
            K.minuteElement.max = 60,
            K.hourElement.title = K.minuteElement.title = Flatpickr.l10n.scrollTitle,
            K.timeContainer.appendChild(K.hourElement),
            K.timeContainer.appendChild(e),
            K.timeContainer.appendChild(K.minuteElement),
        K.config.enableSeconds && (K.timeContainer.classList.add("has-seconds"), K.secondElement = W("input", "flatpickr-second"), K.secondElement.type = "number", K.secondElement.value = K.selectedDateObj ? D(K.selectedDateObj.getSeconds()) : "00", K.secondElement.step = K.minuteElement.step, K.secondElement.min = K.minuteElement.min, K.secondElement.max = K.minuteElement.max, K.timeContainer.appendChild(W("span", "flatpickr-time-separator", ":")), K.timeContainer.appendChild(K.secondElement)),
        K.config.time_24hr || (K.amPM = W("span", "flatpickr-am-pm", ["AM", "PM"][K.hourElement.value > 11 | 0]), K.amPM.title = Flatpickr.l10n.toggleTitle, K.amPM.tabIndex = 0, K.timeContainer.appendChild(K.amPM)),
            K.timeContainer
    }

    function s() {
        K.weekdayContainer || (K.weekdayContainer = W("div", "flatpickr-weekdays"));
        var e = Flatpickr.l10n.firstDayOfWeek,
            t = Flatpickr.l10n.weekdays.shorthand.slice();
        return e > 0 && e < t.length && (t = [].concat(t.splice(e, t.length), t.splice(0, e))),
            K.weekdayContainer.innerHTML = "\n\t\t<span class=flatpickr-weekday>\n\t\t\t" + t.join("</span><span class=flatpickr-weekday>") + "\n\t\t</span>\n\t\t",
            K.weekdayContainer
    }

    function d() {
        return K.calendarContainer.classList.add("hasWeeks"),
            K.weekWrapper = W("div", "flatpickr-weekwrapper"),
            K.weekWrapper.appendChild(W("span", "flatpickr-weekday", Flatpickr.l10n.weekAbbreviation)),
            K.weekNumbers = W("div", "flatpickr-weeks"),
            K.weekWrapper.appendChild(K.weekNumbers),
            K.weekWrapper
    }

    function p(e) {
        K.currentMonth += e,
            b(),
            A(),
            l(),
            (K.config.noCalendar ? K.timeContainer : K.days).focus()
    }

    function f() {
        K.input.value = "",
        K.altInput && (K.altInput.value = ""),
            K.selectedDateObj = null,
            _("Change"),
            i(K.now)
    }

    function m() {
        K.isOpen = !1,
            K.calendarContainer.classList.remove("open"),
            (K.altInput || K.input).classList.remove("active"),
            _("Close")
    }

    function g() {
        K.calendarContainer.parentNode.removeChild(K.calendarContainer),
            K.input.value = "",
        K.altInput && (K.input.type = "text", K.altInput.parentNode.removeChild(K.altInput)),
            document.removeEventListener("keydown", y),
            window.removeEventListener("resize", C),
            document.removeEventListener("click", h),
            document.removeEventListener("blur", h),
            delete K.input._flatpickr
    }

    function h(e) {
        var t = K.calendarContainer.contains(e.target),
            n = K.element.contains(e.target) || e.target === K.altInput;
        !K.isOpen || t || n || K.close()
    }

    function v(e, t) {
        var n = e.split("");
        return n.map(function (e, a) {
            return K.formats[e] && "\\" !== n[a - 1] ? K.formats[e](t) : "\\" !== e ? e : ""
        }).join("")
    }

    function b() {
        (K.currentMonth < 0 || K.currentMonth > 11) && (K.currentYear += K.currentMonth % 11, K.currentMonth = (K.currentMonth + 12) % 12)
    }

    function k(e) {
        if (K.config.minDate && e < K.config.minDate || K.config.maxDate && e > K.config.maxDate) return !1;
        if (!K.config.enable.length && !K.config.disable.length) return !0;
        e = E(e, !0);
        for (var t = K.config.enable.length > 0,
                 n = t ? K.config.enable : K.config.disable, a = void 0, r = 0; r < n.length; r++) {
            if (a = n[r], a instanceof Function && a(e)) return t;
            if ((a instanceof Date || "string" == typeof a) && E(a, !0).getTime() === e.getTime()) return t;
            if ("object" === ("undefined" == typeof a ? "undefined" : _typeof(a)) && a.hasOwnProperty("from") && e >= E(a.from) && e <= E(a.to)) return t
        }
        return !t
    }

    function y(e) {
        if (K.isOpen) switch (e.which) {
            case 13:
                K.timeContainer && K.timeContainer.contains(e.target) ? P(e) : L(e);
                break;
            case 27:
                K.close();
                break;
            case 37:
                e.target !== K.input & e.target !== K.altInput && p(-1);
                break;
            case 38:
                e.preventDefault(),
                    K.timeContainer.contains(e.target) ? a(e) : (K.currentYear++, K.redraw());
                break;
            case 39:
                e.target !== K.input & e.target !== K.altInput && p(1);
                break;
            case 40:
                e.preventDefault(),
                    K.timeContainer.contains(e.target) ? a(e) : (K.currentYear--, K.redraw())
        }
    }

    function C() {
        !K.isOpen || K.config.inline || K.config.static || I()
    }

    function w(e) {
        return K.isMobile ? (e.preventDefault(), e.target.blur(), setTimeout(function () {
                K.mobileInput.click()
            },
            0), void _("Open")) : void(K.isOpen || (K.altInput || K.input).disabled || K.config.inline || (K.calendarContainer.classList.add("open"), K.config.static || I(), K.isOpen = !0, K.config.allowInput || ((K.altInput || K.input).blur(), (K.config.noCalendar ? K.timeContainer : K.selectedDateObj ? K.selectedDateElem : K.days).focus()), (K.altInput || K.input).classList.add("active"), _("Open")))
    }

    function D(e) {
        return ("0" + e).slice(-2)
    }

    function M() {
        if (!K.element.dataset) {
            K.element.dataset = new Object();
        }
        K.config = K.instanceConfig,
            Object.keys(K.element.dataset).forEach(function (e) {
                return K.config[e] = "boolean" == typeof Flatpickr.defaultConfig[e] ? "false" !== K.element.dataset[e] : K.element.dataset[e]
            }),
        !K.config.dateFormat && K.config.enableTime && (K.config.dateFormat = Flatpickr.defaultConfig.dateFormat, K.config.noCalendar ? (K.config.dateFormat = "H:i" + (K.config.enableSeconds ? ":S" : ""), K.config.altFormat = "h:i" + (K.config.enableSeconds ? ":S K" : " K")) : (K.config.dateFormat += " H:i" + (K.config.enableSeconds ? ":S" : ""), K.config.altFormat = "h:i" + (K.config.enableSeconds ? ":S" : "") + " K")),
            Object.keys(Flatpickr.defaultConfig).forEach(function (e) {
                return K.config[e] = "undefined" != typeof K.config[e] ? K.config[e] : Flatpickr.defaultConfig[e]
            })
    }

    function E(e) {
        var t = !(arguments.length <= 1 || void 0 === arguments[1]) && arguments[1],
            n = /(\d+)/g,
            a = /^(\d{1,2})[:\s](\d\d)?[:\s](\d\d)?\s?(a|p)?/i;
        if ("string" == typeof e) if (e = e.trim(), "today" === e) e = new Date,
            t = !0;
        else if (K.config.parseDate) e = K.config.parseDate(e);
        else if (a.test(e)) {
            var r = e.match(a),
                i = r[4] ? r[1] % 12 + ("p" === r[4].toLowerCase() ? 12 : 0) : r[1];
            e = new Date,
                e.setHours(i, r[2] || 0, r[3] || 0)
        } else if (/Z$/.test(e) || /GMT$/.test(e)) e = new Date(e);
        else if (n.test(e)) {
            var o = e.match(n);
            e = new Date(o[0] + "/" + (o[1] || 1) + "/" + (o[2] || 1) + " " + (o[3] || 0) + ":" + (o[4] || 0) + ":" + (o[5] || 0))
        }
        return e instanceof Date && e.getTime() ? (K.config.utc && !e.fp_isUTC && (e = e.fp_toUTC()), t && e.setHours(0, 0, 0, 0), e) : (console.warn("flatpickr: invalid date " + e), console.info(K.element), null)
    }

    function I() {
        var e = K.calendarContainer.offsetHeight,
            t = K.altInput || K.input,
            n = t.getBoundingClientRect(),
            a = window.innerHeight - n.bottom + t.offsetHeight,
            r = void 0,
            i = window.pageXOffset + n.left;
        a < e ? (r = window.pageYOffset - e + n.top - 2, K.calendarContainer.classList.remove("arrowTop"), K.calendarContainer.classList.add("arrowBottom")) : (r = window.pageYOffset + t.offsetHeight + n.top + 2, K.calendarContainer.classList.remove("arrowBottom"), K.calendarContainer.classList.add("arrowTop")),
        K.config.inline || (K.calendarContainer.style.top = r + "px", K.calendarContainer.style.left = i + "px")
    }

    function T() {
        K.config.noCalendar || K.isMobile || (s(), A(), l())
    }

    function L(e) {
        if (e.preventDefault(), e.stopPropagation(), !K.config.allowInput || 13 !== e.which || e.target !== K.altInput && e.target !== K.input) {
            if (e.target.classList.contains("flatpickr-day") && !e.target.classList.contains("disabled")) {
                var t = e.target.classList.contains("prevMonthDay"),
                    n = e.target.classList.contains("nextMonthDay");
                (t || n) && p(+n - t),
                    K.selectedDateObj = new Date(K.currentYear, K.currentMonth, e.target.innerHTML),
                    P(e),
                    l(),
                    _("Change"),
                K.config.enableTime || K.close()
            }
        } else K.setDate((K.altInput || K.input).value)
    }

    function O(e, t) {
        K.config[e] = t,
            i()
    }

    function x(e, t) {
        e = E(e),
            e instanceof Date && e.getTime() ? (K.selectedDateObj = e, i(K.selectedDateObj), P(!1), t && _("Change")) : (K.altInput || K.input).value = ""
    }

    function F() {
        K.now = new Date,
        (K.config.defaultDate || K.input.value) && (K.selectedDateObj = E(K.config.defaultDate || K.input.value)),
        K.config.minDate && (K.config.minDate = E(K.config.minDate, !0)),
        K.config.maxDate && (K.config.maxDate = E(K.config.maxDate, !0));
        var e = K.selectedDateObj || K.config.defaultDate || K.config.minDate || new Date;
        K.currentYear = e.getFullYear(),
            K.currentMonth = e.getMonth()
    }

    function j() {
        K.formats = {
            D: function (e) {
                return Flatpickr.l10n.weekdays.shorthand[K.formats.w(e)]
            },
            F: function (e) {
                return K.utils.monthToStr(K.formats.n(e) - 1, !1)
            },
            H: function (e) {
                return D(e.getHours())
            },
            J: function (e) {
                return e.getDate() + Flatpickr.l10n.ordinal(e.getDate())
            },
            K: function (e) {
                return e.getHours() > 11 ? "PM" : "AM"
            },
            M: function (e) {
                return K.utils.monthToStr(e.getMonth(), !0)
            },
            S: function (e) {
                return D(e.getSeconds())
            },
            U: function (e) {
                return e.getTime() / 1e3
            },
            Y: function (e) {
                return e.getFullYear()
            },
            d: function (e) {
                return D(K.formats.j(e))
            },
            h: function (e) {
                return e.getHours() % 12 ? e.getHours() % 12 : 12
            },
            i: function (e) {
                return D(e.getMinutes())
            },
            j: function (e) {
                return e.getDate()
            },
            l: function (e) {
                return Flatpickr.l10n.weekdays.longhand[K.formats.w(e)]
            },
            m: function (e) {
                return D(K.formats.n(e))
            },
            n: function (e) {
                return e.getMonth() + 1
            },
            s: function (e) {
                return e.getSeconds()
            },
            w: function (e) {
                return e.getDay()
            },
            y: function (e) {
                return String(K.formats.Y(e)).substring(2)
            }
        }
    }

    function Y() {
        K.utils = {
            getDaysinMonth: function () {
                var e = arguments.length <= 0 || void 0 === arguments[0] ? K.currentMonth : arguments[0],
                    t = arguments.length <= 1 || void 0 === arguments[1] ? K.currentYear : arguments[1];
                return 1 === e && t % 4 === 0 && t % 100 !== 0 || t % 400 === 0 ? 29 : Flatpickr.l10n.daysInMonth[e]
            },
            monthToStr: function (e) {
                var t = arguments.length <= 1 || void 0 === arguments[1] ? K.config.shorthandCurrentMonth : arguments[1];
                return Flatpickr.l10n.months[(t ? "short" : "long") + "hand"][e]
            }
        }
    }

    function S() {
        K.input = K.config.wrap ? K.element.querySelector("[data-input]") : K.element,
            K.input.classList.add("flatpickr-input"),
        K.config.altInput && (K.altInput = W(K.input.nodeName, "flatpickr-input " + K.config.altInputClass), K.altInput.placeholder = K.input.placeholder, K.altInput.type = "text", K.input.type = "hidden", K.input.parentNode.insertBefore(K.altInput, K.input.nextSibling)),
        K.config.allowInput || (K.altInput || K.input).setAttribute("readonly", "readonly")
    }

    function N() {
        var e = K.config.enableTime ? K.config.noCalendar ? "time" : "datetime-local" : "date";
        if (K.mobileInput = W("input", "flatpickr-input"), K.mobileInput.step = "any", K.mobileInput.tabIndex = -1, K.mobileInput.type = e, K.selectedDateObj) {
            var t = "datetime-local" === e ? "Y-m-d\\TH:i:S" : "date" === e ? "Y-m-d" : "H:i:S",
                n = v(t, K.selectedDateObj);
            K.mobileInput.defaultValue = K.mobileInput.value = n
        }
        K.config.minDate && (K.mobileInput.min = v("Y-m-d", K.config.minDate)),
        K.config.maxDate && (K.mobileInput.max = v("Y-m-d", K.config.maxDate)),
            K.input.type = "hidden",
        K.config.altInput && (K.altInput.type = "hidden");
        try {
            K.input.parentNode.insertBefore(K.mobileInput, K.input.nextSibling)
        } catch (e) {
        }
        K.mobileInput.addEventListener("change",
            function (e) {
                K.setDate(e.target.value),
                    _("Change"),
                    _("Close")
            })
    }

    function H() {
        K.isOpen ? K.close() : K.open()
    }

    function _(e) {
        K.config["on" + e] && K.config["on" + e](K.selectedDateObj, K.input.value, K)
    }

    function A() {
        K.currentMonthElement.textContent = K.utils.monthToStr(K.currentMonth) + " ",
            K.currentYearElement.value = K.currentYear
    }

    function P() {
        var e = arguments.length <= 0 || void 0 === arguments[0] || arguments[0];
        if (K.config.noCalendar && !K.selectedDateObj) K.selectedDateObj = new Date;
        else if (!K.selectedDateObj) return;
        if (K.config.enableTime && !K.isMobile) {
            var t = void 0,
                n = void 0,
                a = void 0;
            e ? (t = parseInt(K.hourElement.value, 10) || 0, n = (60 + (parseInt(K.minuteElement.value, 10) || 0)) % 60, K.config.enableSeconds && (a = (60 + parseInt(K.secondElement.value, 10) || 0) % 60), K.config.time_24hr || (t = t % 12 + 12 * ("PM" === K.amPM.innerHTML)), K.selectedDateObj.setHours(t, n, a || 0, 0)) : (t = K.selectedDateObj.getHours(), n = K.selectedDateObj.getMinutes(), a = K.selectedDateObj.getSeconds()),
                K.hourElement.value = D(K.config.time_24hr ? t : (12 + t) % 12 + 12 * (t % 12 === 0)),
                K.minuteElement.value = D(n),
            void 0 !== K.secondElement && (K.secondElement.value = D(a))
        }
        K.input.value = v(K.config.dateFormat, K.selectedDateObj),
        K.altInput && (K.altInput.value = v(K.config.altFormat, K.selectedDateObj)),
            _("ValueUpdate")
    }

    function U(e) {
        e.preventDefault();
        var t = Math.max(-1, Math.min(1, e.wheelDelta || -e.deltaY));
        K.currentYear = e.target.value = parseInt(e.target.value, 10) + t,
            K.redraw()
    }

    function W(e) {
        var t = arguments.length <= 1 || void 0 === arguments[1] ? "" : arguments[1],
            n = arguments.length <= 2 || void 0 === arguments[2] ? "" : arguments[2],
            a = document.createElement(e);
        return a.className = t,
        n && (a.textContent = n),
            a
    }

    function B(e, t, n) {
        var a = void 0;
        return function () {
            for (var r = arguments.length,
                     i = Array(r), o = 0; o < r; o++) i[o] = arguments[o];
            var l = this,
                c = function () {
                    a = null,
                    n || e.apply(l, i)
                };
            clearTimeout(a),
                a = setTimeout(c, t),
            n && !a && e.apply(l, i)
        }
    }

    function J(e, t) {
        return e.getDate() === t.getDate() && e.getMonth() === t.getMonth() && e.getFullYear() === t.getFullYear()
    }

    function z(e) {
        if (e.preventDefault(), e && "keydown" !== e.type && e.target.blur(), "flatpickr-am-pm" === e.target.className) return e.target.textContent = ["AM", "PM"]["AM" === e.target.textContent | 0],
            void e.stopPropagation();
        var t = parseInt(e.target.min, 10),
            n = parseInt(e.target.max, 10),
            a = parseInt(e.target.step, 10),
            r = parseInt(e.target.value, 10),
            i = r;
        "wheel" === e.type ? i = r + a * Math.max(-1, Math.min(1, e.wheelDelta || -e.deltaY)) : "keydown" === e.type && (i = r + a * (38 === e.which ? 1 : -1)),
            i <= t ? i = n - a : i >= n && (i = t + a),
            e.target.value = D(i)
    }

    var K = this;
    return n(),
        K
}

function _flatpickr(e, t) {
    for (var n = [], a = 0; a < e.length; a++) {
        e[a]._flatpickr && e[a]._flatpickr.destroy();
        try {
            e[a]._flatpickr = new Flatpickr(e[a], t || {}),
                n.push(e[a]._flatpickr)
        } catch (e) {
            console.warn(e, e.stack)
        }
    }
    return 1 === n.length ? n[0] : n
}

var _typeof = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ?
    function (e) {
        return typeof e
    } : function (e) {
        return e && "function" == typeof Symbol && e.constructor === Symbol ? "symbol" : typeof e
    };
Flatpickr.defaultConfig = {
    utc: !1,
    wrap: !1,
    weekNumbers: !1,
    allowInput: !1,
    clickOpens: !0,
    time_24hr: !1,
    enableTime: !1,
    noCalendar: !1,
    dateFormat: "Y-m-d",
    altInput: null,
    altInputClass: "",
    altFormat: "F j, Y",
    defaultDate: null,
    minDate: null,
    maxDate: null,
    parseDate: null,
    initDate: null,
    enable: [],
    disable: [],
    shorthandCurrentMonth: !1,
    inline: !1,
    static: !1,
    prevArrow: "<svg version='1.1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' viewBox='0 0 17 17'><g></g><path d='M5.207 8.471l7.146 7.147-0.707 0.707-7.853-7.854 7.854-7.853 0.707 0.707-7.147 7.146z' /></svg>",
    nextArrow: "<svg version='1.1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' viewBox='0 0 17 17'><g></g><path d='M13.207 8.472l-7.854 7.854-0.707-0.707 7.146-7.146-7.146-7.148 0.707-0.707 7.854 7.854z' /></svg>",
    enableSeconds: !1,
    hourIncrement: 1,
    minuteIncrement: 5,
    disableMobile: !1,
    onChange: null,
    onOpen: null,
    onClose: null,
    onReady: null,
    onValueUpdate: null
},
    Flatpickr.l10n = {
        weekdays: {
            shorthand: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
            longhand: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]
        },
        months: {
            shorthand: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
            longhand: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
        },
        daysInMonth: [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31],
        firstDayOfWeek: 0,
        ordinal: function (e) {
            var t = e % 100;
            if (t > 3 && t < 21) return "th";
            switch (t % 10) {
                case 1:
                    return "st";
                case 2:
                    return "nd";
                case 3:
                    return "rd";
                default:
                    return "th"
            }
        },
        weekAbbreviation: "Wk",
        scrollTitle: "Scroll to increment",
        toggleTitle: "Click to toggle"
    },
    Flatpickr.localize = function (e) {
        Object.keys(e).forEach(function (t) {
            return Flatpickr.l10n[t] = e[t]
        })
    },
    HTMLCollection.prototype.flatpickr = NodeList.prototype.flatpickr = function (e) {
        return _flatpickr(this, e)
    },
    HTMLElement.prototype.flatpickr = function (e) {
        return _flatpickr([this], e)
    },
"undefined" != typeof jQuery && (jQuery.fn.flatpickr = function (e) {
    return _flatpickr(this, e)
}),
    Date.prototype.fp_incr = function (e) {
        return new Date(this.getFullYear(), this.getMonth(), this.getDate() + parseInt(e, 10))
    },
    Date.prototype.fp_isUTC = !1,
    Date.prototype.fp_toUTC = function () {
        var e = new Date(this.getUTCFullYear(), this.getUTCMonth(), this.getUTCDate(), this.getUTCHours(), this.getUTCMinutes(), this.getUTCSeconds());
        return e.fp_isUTC = !0,
            e
    },
    Date.prototype.format = function (format) {
        var date = {
            "M+": this.getMonth() + 1,
            "d+": this.getDate(),
            "h+": this.getHours(),
            "m+": this.getMinutes(),
            "s+": this.getSeconds(),
            "q+": Math.floor((this.getMonth() + 3) / 3),
            "S+": this.getMilliseconds()
        };
        if (/(y+)/i.test(format)) {
            format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
        }
        for (var k in date) {
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1
                    ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
            }
        }
        return format;
    },
    String.prototype.datetimeToDate = function () {
        return new Date(Date.parse(this));
    },
    Flatpickr.prototype.getWeek = function (e) {
        var t = new Date(e.getTime());
        t.setHours(0, 0, 0, 0),
            t.setDate(t.getDate() + 3 - (t.getDay() + 6) % 7);
        var n = new Date(t.getFullYear(), 0, 4);
        return 1 + Math.round(((t.getTime() - n.getTime()) / 864e5 - 3 + (n.getDay() + 6) % 7) / 7)
    },
    Flatpickr.initDateTimePick = function (e1, e2, hasMaxDate) {
        var _maxDate = 'today';
        if (!hasMaxDate && typeof hasMaxDate === 'boolean') {
            _maxDate = null;
        }
        var _start = e1.flatpickr({
            maxDate: _maxDate,
            enableTime: true,
            enableSeconds: true,
            time_24hr: true
        });
        var _end = e2.flatpickr({
            maxDate: _maxDate,
            enableTime: true,
            enableSeconds: true,
            time_24hr: true
        });

        _end.config.onOpen = function (date) {
            var endTime = e2.val();
            if (endTime) {
                this.initDate = date;
            }
        };
        _end.config.onChange = function (date) {
            var startTime = e1.val();
            if (startTime) {
                var time = startTime.datetimeToDate();
                if (time >= date) {
                    if (!this.initDate) {
                        e2.val('');
                    } else {
                        var initTime = this.initDate.format('yyyy-MM-dd hh:mm:ss');
                        e2.val(initTime);
                    }
                    base.alert('结束日期不能小于开始日期！');
                } else {
                    this.initDate = date;
                }
            } else {
                this.initDate = date;
            }
            _start.set("maxDate", this.initDate);
        };
    },
    Flatpickr.reload = function (e1, e2) {
        e1.empty();
        e2.empty();
        this.initDateTimePick(e1, e2);
    },
"classList" in document.documentElement || !Object.defineProperty || "undefined" == typeof HTMLElement || Object.defineProperty(HTMLElement.prototype, "classList", {
    get: function () {
        function e(e) {
            return function (n) {
                var a = t.className.split(/\s+/),
                    r = a.indexOf(n);
                e(a, r, n),
                    t.className = a.join(" ")
            }
        }

        var t = this,
            n = {
                add: e(function (e, t, n) {
                    ~t || e.push(n)
                }),
                remove: e(function (e, t) {
                    ~t && e.splice(t, 1)
                }),
                toggle: e(function (e, t, n) {
                    ~t ? e.splice(t, 1) : e.push(n)
                }),
                contains: function (e) {
                    return !!~t.className.split(/\s+/).indexOf(e)
                },
                item: function (e) {
                    return t.className.split(/\s+/)[e] || null
                }
            };
        return Object.defineProperty(n, "length", {
            get: function () {
                return t.className.split(/\s+/).length
            }
        }),
            n
    }
}),
"undefined" != typeof module && (module.exports = Flatpickr);