package org.mansumugang.mansumugang_service.dto.medicine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class MedicineSchedule {
    @Getter
    @AllArgsConstructor
    @Builder
    public static class Element {
        private LocalTime time;
        private List<MedicineSummaryInfoDto> medicines;

        public static Element of(LocalTime time, List<MedicineSummaryInfoDto> medicines) {
            return Element.builder()
                    .time(time)
                    .medicines(medicines)
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class Dto{
        private LocalDate date;
        private List<Element> medicineSchedules;

        public static Dto of(LocalDate date, List<Element> medicineSchedules) {
            return Dto.builder()
                    .date(date)
                    .medicineSchedules(medicineSchedules)
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class Response{
        private LocalDate date;
        private List<Element> medicineSchedules;

        public static Response fromDto(Dto dto) {
            return Response.builder()
                    .date(dto.getDate())
                    .medicineSchedules(dto.getMedicineSchedules())
                    .build();
        }
    }
}
