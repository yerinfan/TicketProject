package kr.ac.kopo.framework;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import kr.ac.kopo.service.ReservationService;

public class ReservationScheduler {

    private final ReservationService service = new ReservationService();

    public static void main(String[] args) {
        ReservationScheduler scheduler = new ReservationScheduler();
        scheduler.scheduleTasks();
    }

    public void scheduleTasks() {
        Timer timer = new Timer();

        // 금요일 오후 10시에 실행
        timer.schedule(new DisableTask(), getNextTime(Calendar.FRIDAY, 22, 0));

        // 토요일 오후 2시에 실행
        timer.schedule(new EnableTask(), getNextTime(Calendar.SATURDAY, 14, 0));
    }

    // 금요일 오후 10시 작업
    class DisableTask extends TimerTask {
        @Override
        public void run() {
            service.updateReservationStatus("DISABLED");
            System.out.println("자리 선점하기 버튼 비활성화");
        }
    }

    // 토요일 오후 2시 작업
    class EnableTask extends TimerTask {
        @Override
        public void run() {
            service.updateReservationStatus("ENABLED");
            System.out.println("자리 선점하기 버튼 활성화");
        }
    }

    private Date getNextTime(int dayOfWeek, int hour, int minute) {
        Calendar now = Calendar.getInstance();
        Calendar nextTime = Calendar.getInstance();

        // 현재 시간 기준으로 다음 실행 시간 설정
        nextTime.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        nextTime.set(Calendar.HOUR_OF_DAY, hour);
        nextTime.set(Calendar.MINUTE, minute);
        nextTime.set(Calendar.SECOND, 0);
        nextTime.set(Calendar.MILLISECOND, 0);

        // 요일이 현재보다 이전일 경우 다음 주로 설정
        if (now.after(nextTime)) {
            nextTime.add(Calendar.WEEK_OF_YEAR, 1);
        }

        return nextTime.getTime();
    }
}
