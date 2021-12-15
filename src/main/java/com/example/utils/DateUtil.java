package com.example.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

    /**
     * 判断字符串，是否是一个日期
     * @param date
     * @return
     */
    public static final boolean isDate(String date) {
        boolean b = true;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.SIMPLIFIED_CHINESE);
            sdf.setLenient(false);
            sdf.parse(date);
        } catch (ParseException var3) {
            b = false;
        }
        return b;
    }


    /**
     * 获取时间日期  yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static final Date getDate(String date) {
        Date d = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);
            d = sdf.parse(date);
            return d;
        } catch (ParseException var3) {
            var3.printStackTrace();
            throw new RuntimeException("日期格式异常");
        }
    }

    /**
     *  获取当前时间
     * @return
     */
    public static final Date getDate() {
        return new Date();
    }

    /**
     * 传 时间 日期格式 ，按照日期格式化输出
     * @param date  时间
     * @param format    日期格式
     * @return
     */
    public static final String getFormatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.SIMPLIFIED_CHINESE);
        return sdf.format(date);
    }

    /**
     * 传 时间 日期格式 ，按照 yyyy-MM-dd格式化输出
     * @param date  时间
     * @param format    日期格式
     * @return
     */
    public static final String getStandardDate(Date date) {
        return getFormatDate(date, "yyyy-MM-dd");
    }

    /**
     * 获取当前时间，按照 yyyy-MM-dd格式化输出
     * @return
     */
    public static final String getStandardDate() {
        return getStandardDate(getDate());
    }

    /**
     * 传 时间 格式 ，按照 yyyy-MM-dd HH:mm:ss 格式化输出
     * @param date  时间
     * @return
     */
    public static final String getStandardDateTime(Date date) {
        return getFormatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当前时间，按照 yyyy-MM-dd HH:mm:ss 格式化输出
     * @return
     */
    public static final String getStandardDateTime() {
        return getStandardDateTime(getDate());
    }

    private static final Date addInteger(Date date, int amount, int field) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(field, amount);
        return c.getTime();
    }

    public static final Date addHour(Date date, int amount) {
        return addInteger(date, amount, 11);
    }

    public static final Date addMinute(Date date, int amount) {
        return addInteger(date, amount, 12);
    }

    public static final Date addSecond(Date date, int amount) {
        return addInteger(date, amount, 13);
    }

    public static final Date addYear(Date date, int amount) {
        return addInteger(date, amount, 1);
    }

    public static final Date addMonth(Date date, int amount) {
        return addInteger(date, amount, 2);
    }

    public static final Date addDay(Date date, int amount) {
        return addInteger(date, amount, 6);
    }

    public static final Date addWeek(Date date, int amount) {
        return addInteger(date, amount, 3);
    }

    public static final Boolean isWeekend(Date date) {
        return false;
    }


    public static String time2String4(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String yyyyMMddHHmmssSSS = simple.format(date);
        return yyyyMMddHHmmssSSS;
    }


    public static String time2String(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String yyyyMMddHHmmss = simple.format(date);
        return yyyyMMddHHmmss;
    }

    public static String time3String(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String yyyyMMddHHmmss = simple.format(date);
        return yyyyMMddHHmmss;
    }


    public static String now() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sDateFormat.format(new Date());
    }

    public static Date now1() {
        Date date = null;
        try {
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = simple.parse(simple.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String time2String2(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");
        String yyyyMMddHHmmss = simple.format(date);
        return yyyyMMddHHmmss;
    }

    public static String time2String3(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
        String yyyyMMdd = simple.format(date);
        return yyyyMMdd;
    }

    public static String time2String6(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simple = new SimpleDateFormat("yyyyMM");
        String yyyyMMdd = simple.format(date);
        return yyyyMMdd;
    }

    public static String time2String5(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simple = new SimpleDateFormat("HHmmss");
        String yyyyMMdd = simple.format(date);
        return yyyyMMdd;
    }

    public static Date string2Time(String dateStr) {
        Date date = null;
        try {
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = simple.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date string4Time(String dateStr) {
        Date date = null;
        try {
            SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            date = simple.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date string3Time(String dateStr) {
        Date date = null;
        try {
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            date = simple.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date string2Time2(String dateStr) {
        Date date = null;
        try {
            SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");
            date = simple.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date string2Date_yyyyMMdd(String dateStr) {
        Date date = null;
        try {
            SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
            date = simple.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static int getMonthSpace_yyyyMM(String syyyyMM, String eyyyyMM) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(syyyyMM));
            c2.setTime(sdf.parse(eyyyyMM));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int yearSpace = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        int monthSpace = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        int result = (yearSpace * 12) + monthSpace;
        return result;
    }

    public static String getLastDayOfMonth(String yyyyMM) {
        try {
            GregorianCalendar cal = new GregorianCalendar();
            String yyyy = yyyyMM.substring(0, 4);
            String MM = yyyyMM.substring(4, 6);
            int year = Integer.valueOf(yyyy);
            int month = Integer.valueOf(MM);
            cal.set(Calendar.YEAR, year);
            //注意：月份是从0开始的，比如说如果输入5的话，实际上显示的是4月份的最后一天，千万不要搞错了哦
            cal.set(Calendar.MONTH, month - 1);
            //某年某月的最后一天
            int maxDay = cal.getActualMaximum(Calendar.DATE);
//			SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
            String LastDay = yyyyMM + maxDay;
            return LastDay;
//			Date LastDay = simple.parse(yyyyMM+maxDay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return yyyyMM;
    }

    public static Date getLastDayOfMonth2(String yyyyMM) {
        try {
            GregorianCalendar cal = new GregorianCalendar();
            String yyyy = yyyyMM.substring(0, 4);
            String MM = yyyyMM.substring(4, 6);
            int year = Integer.valueOf(yyyy);
            int month = Integer.valueOf(MM);
            cal.set(Calendar.YEAR, year);
            //注意：月份是从0开始的，比如说如果输入5的话，实际上显示的是4月份的最后一天，千万不要搞错了哦
            cal.set(Calendar.MONTH, month - 1);
            //某年某月的最后一天
            int maxDay = cal.getActualMaximum(Calendar.DATE);
            SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
            Date LastDay = simple.parse(yyyyMM + maxDay);
            return LastDay;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 月份加减
     */
    public static String calculationOfMonth(Date date, int amount) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            cal.set(Calendar.DATE, 1);    //设为当前月的1号
            cal.add(Calendar.MONTH, amount);    //加减月份

            return sdf.format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期加减	yyyy-MM-dd'T'HH:mm:ss
     */
    public static String calculationOfDay(Date date, int amount) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cal.add(Calendar.DAY_OF_MONTH, amount);    //加减月份
            return sdf.format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期加减	yyyy-MM-dd HH:mm:ss
     */
    public static String calculationOfDay1(Date date, int amount) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            cal.add(Calendar.DAY_OF_MONTH, amount);    //加减月份

            return sdf.format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 计算当月最后一天,返回字符串  
    public static String getDefaultDay(Date date) {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar lastDate = Calendar.getInstance();
        lastDate.setTime(date);
        lastDate.set(Calendar.DATE, 1);//设为当前月的1号
        lastDate.add(Calendar.MONTH, 1);//加一个月，变为下月的1号
        lastDate.add(Calendar.DATE, -1);//减去一天，变为当月最后一天

        str = sdf.format(lastDate.getTime());
        return str;
    }

    /**
     * 分钟加减	yyyyMMdd
     */
    public static String calculationOfMinute(Date date, int amount) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

            cal.add(Calendar.MINUTE, amount);    //加减月份

            return sdf.format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String thatDayStart(String time, int day) {
        Date date = new Date();
        if (day == 1) {
            day = 0;
        }
        date = string2Time(calculationOfDay1(string2Time(time), -day));
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(date);
        todayStart.set(Calendar.HOUR, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return time2String(todayStart.getTime());
    }

    //获取最晚时间 0代表今天 1代表明天 -1代表昨天 以此类推.
    public static String thatDayEndTime(int day) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.add(Calendar.DATE, day);
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        return time2String(todayEnd.getTime());
    }

    //获取最早时间 0代表今天 1代表明天 -1代表昨天 以此类推.
    public static String thatDayStartTime(int day) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.add(Calendar.DATE, day);
        todayEnd.set(Calendar.HOUR, 0);
        todayEnd.set(Calendar.MINUTE, 0);
        todayEnd.set(Calendar.SECOND, 0);
        return time2String(todayEnd.getTime());
    }

    /***
     * 比较时间大小，传入的时间与系统时间比较
     * 传入的时间格式 2016-11-19 11:02:44
     * @return
     */
    public static boolean calculationDate(String bjDate) {
        Date dateTime1 = null;
        Date dateTime2 = null;
        int i = 0;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateTime1 = dateFormat.parse(bjDate);//传入的时间
            dateTime2 = dateFormat.parse(dateFormat.format(new Date()));//系统时间
            i = dateTime1.compareTo(dateTime2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i < 0;
    }

    /***
     * 计算倒计时描述，传入的时间与系统时间比较
     * 传入的时间格式 2016-11-19 11:02:44
     * @return
     */
    public static long getCountDown(String endTime) {
        if (endTime == null) {
            return 0;
        }
        long countDown = 0;
        Date killTime = DateUtil.string2Time(endTime);
        long time1 = killTime.getTime();
        long time2 = new Date().getTime();
        long v = (time1 - time2) / 1000;
        countDown = v > 0 ? v : 0;
        return countDown;
    }

    public static String timeTo2YYYYMMDD(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simple = new SimpleDateFormat("yyyy年MM月dd日");
        String YYYYMMDD = simple.format(date);
        return YYYYMMDD;
    }

    /**
     * 比较时间大小
     *
     * @param time1
     * @param time2
     * @return
     * @throws ParseException
     */
    public static boolean compare(String time1, String time2) throws ParseException {
        Date dateTime1 = null;
        Date dateTime2 = null;
        int i = 0;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateTime1 = dateFormat.parse(time1);//传入的时间
            dateTime2 = dateFormat.parse(time2);//系统时间
            i = dateTime1.compareTo(dateTime2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i < 0;
    }

    public static int getMonths(Date beginDate, Date endDate) {
        if ((beginDate == null) || (endDate == null) || (endDate.before(beginDate))) {
            throw new IllegalArgumentException("时间参数为空,或时间大小不对！");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        int year = calendar.get(1);
        int month = calendar.get(2);
        calendar.setTime(endDate);
        int i = (calendar.get(1) - year) * 12;
        month = calendar.get(2) - month;
        return i + month;
    }

    public static String dateToString(String dateFormat) {
        return dateToString(new Date(), dateFormat);
    }

    public static String dateToString(Date date, String dateFormat) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat();
        if (date != null && dateFormat != null && dateFormat.trim().length() != 0) {
            dateFormatter.applyPattern(dateFormat);
            String dateString = dateFormatter.format(date);
            return dateString;
        } else {
            throw new IllegalArgumentException("时间参数或时间格式参数不能为空！");
        }
    }

    public static boolean compareDate(String A, String B, int time) {
        //主订单开始时间
        long dateA = string2Time(A).getTime();
        //匹配订单时间
        long dateB = string2Time(B).getTime();
        //规则时间
        long ruleTime = time * 24 * 60 * 60 * 1000;
        //时间差
        long difference = dateA - dateB;
        if (difference > ruleTime || difference < 0) {
            return false;
        } else {
            return true;
        }
    }

    //通过余弦定理比较地址分词后的相似度
    public static double getSimilarity(List<String> T1, List<String> T2) throws Exception {
        double Wi = 0.2;
        int size = 0, size2 = 0;
        if (T1 != null && (size = T1.size()) > 0 && T2 != null && (size2 = T2.size()) > 0) {
            Map<String, double[]> T = new HashMap<String, double[]>();
            //T1和T2的并集T
            String index = null;
            for (int i = 0; i < size; i++) {
                index = T1.get(i);
                if (index != null) {
                    double[] c = T.get(index);
                    c = new double[2];
                    c[0] = 1;    //T1的语义分数Ci
                    c[1] = Wi;//T2的语义分数Ci
                    T.put(index, c);
                }
            }
            for (int i = 0; i < size2; i++) {
                index = T2.get(i);
                if (index != null) {
                    double[] c = T.get(index);
                    if (c != null && c.length == 2) {
                        c[1] = 1; //T2中也存在，T2的语义分数=1
                    } else {
                        c = new double[2];
                        c[0] = Wi; //T1的语义分数Ci
                        c[1] = 1; //T2的语义分数Ci
                        T.put(index, c);
                    }
                }
            }
            //开始计算，百分比
            Iterator<String> it = T.keySet().iterator();
            double s1 = 0, s2 = 0, Sum = 0;  //S1、S2
            while (it.hasNext()) {
                double[] c = T.get(it.next());
                Sum += c[0] * c[1];
                s1 += c[0] * c[0];
                s2 += c[1] * c[1];
            }
            //百分比
            return Sum / Math.sqrt(s1 * s2);
        } else {
            throw new Exception("传入参数有问题！");
        }
    }

//获取本月第一天
    public static String getMonthFirstDay(){
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH,0);

        str = sdf.format(calendar.getTime());
        return str;
    }
    //获取本月
    public static String getMonth(){
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH,0);

        str = sdf.format(calendar.getTime());
        return str;
    }
    //获取本月最后一天

    public static Date getMonthLastDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH,0);
        calendar.add(Calendar.MONTH,1);
        return calendar.getTime();
    }



    /**
     * 获取当前时间所在周的周一和周日的日期时间
     * @return
     */
    public static Map<String,String> getWeekDate() {
        Map<String,String> map = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if(dayWeek==1){
            dayWeek = 8;
        }

        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        Date mondayDate = cal.getTime();
        String weekBegin = sdf.format(mondayDate);

        cal.add(Calendar.DATE, 4 +cal.getFirstDayOfWeek());
        Date sundayDate = cal.getTime();
        String weekEnd = sdf.format(sundayDate);

        map.put("mondayDate", weekBegin);
        map.put("sundayDate", weekEnd);
        return map;
    }


    /**
     * 获取上个月的最后一天
     * @return
     */
    public  static String getBeforLastData(){

        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar=Calendar.getInstance();

        int month=calendar.get(Calendar.MONTH);

        calendar.set(Calendar.MONTH, month-1);

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        String lastData = sf.format(calendar.getTime());
        return lastData;

    }


    /**
     *  获取上个月的第一天
     */

    public  static String  getBeforFristData(){

        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar=Calendar.getInstance();

        calendar.add(Calendar.MONTH, -1);

        calendar.set(Calendar.DAY_OF_MONTH, 1);

        String fristData = format.format(calendar.getTime());
        return fristData;

    }


    /**
     * 获取指定年月的第一天
     * @param ym yyyy-MM
     * @return
     */
    public static String getFirstDayForMonth(String ym) {
        String arr[] = ym.split("-");

        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);

        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);

        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(cal.getTime());
    }

    /**
     * 获取指定年月的最后一天
     * @param ym
     * @return
     */
    public static String getLastDayForMonth(String ym) {
        String arr[] = ym.split("-");

        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);

        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * 计算两个字符串日期之间的天数差
     * @param a 开始日期
     * @param b 结束日期
     * @return
     */
    public static Long between_days(String a, String b) {
        // 自定义时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar_a = Calendar.getInstance();// 获取日历对象
        Calendar calendar_b = Calendar.getInstance();
        Date date_a = null;
        Date date_b = null;
        try {
            //字符串转Date
            date_a = simpleDateFormat.parse(a);
            date_b = simpleDateFormat.parse(b);
            // 设置日历
            calendar_a.setTime(date_a);
            calendar_b.setTime(date_b);
        } catch (ParseException e) {
            //格式化异常
            e.printStackTrace();
        }

        long time_a = calendar_a.getTimeInMillis();
        long time_b = calendar_b.getTimeInMillis();
        //计算相差天数
        long between_days = (time_b - time_a) / (1000 * 3600 * 24);

        return between_days;
    }


    /**
     *根据身份证号码计算年龄
     * @param idNumber 考虑到了15位身份证，但不一定存在
     */

    public static int getAgeByIDNumber(String idNumber) {
        String dateStr;
        if (idNumber.length() == 15) {
            dateStr = "19" + idNumber.substring(6, 12);
        } else if (idNumber.length() == 18) {
            dateStr = idNumber.substring(6, 14);
        } else {//默认是合法身份证号，但不排除有意外发生
            return -1;
        }


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            Date birthday = simpleDateFormat.parse(dateStr);
            return getAgeByDate(birthday);
        } catch (ParseException e) {
            return -1;
        }
    }

    /**
     *根据生日计算年龄
     * @param dateStr 这样格式的生日 1990-01-01
     */

    public static int getAgeByDateString(String dateStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthday = simpleDateFormat.parse(dateStr);
            return getAgeByDate(birthday);
        } catch (ParseException e) {
            return -1;
        }
    }


    public static int getAgeByDate(Date birthday) {
        Calendar calendar = Calendar.getInstance();

        //calendar.before()有的点bug
        if (calendar.getTimeInMillis() - birthday.getTime() < 0L) {
            return -1;
        }


        int yearNow = calendar.get(Calendar.YEAR);
        int monthNow = calendar.get(Calendar.MONTH);
        int dayOfMonthNow = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.setTime(birthday);


        int yearBirthday = calendar.get(Calendar.YEAR);
        int monthBirthday = calendar.get(Calendar.MONTH);
        int dayOfMonthBirthday = calendar.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirthday;


        if (monthNow <= monthBirthday && monthNow == monthBirthday && dayOfMonthNow < dayOfMonthBirthday || monthNow < monthBirthday) {
            age--;
        }

        return age;
    }

}