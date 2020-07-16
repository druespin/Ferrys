package com.akostikov.app.database;

import java.util.Arrays;
import java.util.List;

public class InitialTableData {

    public static List<String[][]> getTables() {
        return Arrays.asList(donsakKotao, kotaoDonsak,
                            donsakSamui, samuiDonsak,
                            donsakPhangan, phanganDonsak,
                            samuiPhangan, phanganSamui,
                            samuiKotao, kotaoSamui,
                            phanganKotao, kotaoPhangan);
    }

    private static String[][] donsakKotao = {
            {"Don Sak", "Ko Tao", "Seatran", "11:00", "Seatran Ferry Pier", "15:00", "Mae Haad Pier", "700 THB"},
            {"Don Sak", "Ko Tao", "Seatran", "14:30", "Seatran Ferry Pier", "18:30", "Mae Haad Pier", "700 THB"},
    };

    private static String[][] kotaoDonsak = {
            {"Ko Tao", "Don Sak", "Seatran", "06:30", "Mae Haad Pier", "10:30", "Seatran Ferry Pier", "700 THB"},
            {"Ko Tao", "Don Sak", "Seatran", "09:00", "Mae Haad Pier", "13:00", "Seatran Ferry Pier", "700 THB"}
    };

    private static String[][] donsakPhangan = {
        {"Don Sak", "Ko Phangan", "Raja", "06:00", "Raja Ferry Pier", "08:30", "Thong Sala Pier", "210 THB"},
        {"Don Sak", "Ko Phangan", "Raja", "08:00", "Raja Ferry Pier", "10:30", "Thong Sala Pier", "210 THB"},
        {"Don Sak", "Ko Phangan", "Raja", "10:00", "Raja Ferry Pier", "12:30", "Thong Sala Pier", "210 THB"},
        {"Don Sak", "Ko Phangan", "Seatran", "11:00", "Seatran Ferry Pier", "13:30", "Thong Sala Pier", "450 THB"},
        {"Don Sak", "Ko Phangan", "Raja", "14:00", "Raja Ferry Pier", "16:30", "Thong Sala Pier", "210 THB"},
        {"Don Sak", "Ko Phangan", "Seatran", "14:30", "Seatran Ferry Pier", "17:00", "Thong Sala Pier", "450 THB"},
        {"Don Sak", "Ko Phangan", "Raja", "16:00", "Raja Ferry Pier", "18:30", "Thong Sala Pier", "210 THB"},
        {"Don Sak", "Ko Phangan", "Raja", "18:00", "Raja Ferry Pier", "20:30", "Thong Sala Pier", "210 THB" }
    };

    private static String[][] phanganDonsak = {
            {"Ko Phangan", "Don Sak", "Raja", "05:00", "Thong Sala Pier", "07:30", "Raja Ferry Pier", "210 THB"},
            {"Ko Phangan", "Don Sak", "Raja", "07:00", "Thong Sala Pier", "09:30", "Raja Ferry Pier", "210 THB"},
            {"Ko Phangan", "Don Sak", "Seatran", "08:00", "Thong Sala Pier", "10:30", "Seatran Ferry Pier", "450 THB" },
            {"Ko Phangan", "Don Sak", "Seatran", "10:30", "Thong Sala Pier", "13:00", "Seatran Ferry Pier", "450 THB" },
            {"Ko Phangan", "Don Sak", "Raja", "11:00", "Thong Sala Pier", "13:30", "Raja Ferry Pier", "210 THB"},
            {"Ko Phangan", "Don Sak", "Raja", "13:00", "Thong Sala Pier", "15:30", "Raja Ferry Pier", "210 THB"},
            {"Ko Phangan", "Don Sak", "Raja", "17:00", "Thong Sala Pier", "19:30", "Raja Ferry Pier", "210 THB"}
    };

    private static String[][] donsakSamui = {
            {"Don Sak", "Ko Samui", "Raja", "07:00", "Raja Ferry Pier", "08:30", "Lipa Noi Pier", "140 THB"},
            {"Don Sak", "Ko Samui", "Raja", "08:00", "Raja Ferry Pier", "09:30", "Lipa Noi Pier", "140 THB"},
            {"Don Sak", "Ko Samui", "Raja", "09:00", "Raja Ferry Pier", "10:30", "Lipa Noi Pier", "140 THB"},
            {"Don Sak", "Ko Samui", "Raja", "10:00", "Raja Ferry Pier", "11:30", "Lipa Noi Pier", "140 THB"},
            {"Don Sak", "Ko Samui", "Raja", "11:00", "Raja Ferry Pier", "12:30", "Lipa Noi Pier", "140 THB"},
            {"Don Sak", "Ko Samui", "Seatran", "11:00", "Seatran Ferry Pier", "12:30", "Bangrak Pier", "350 THB" },
            {"Don Sak", "Ko Samui", "Seatran", "14:30", "Seatran Ferry Pier", "16:00", "Bangrak Pier", "350 THB" },
            {"Don Sak", "Ko Samui", "Raja", "17:00", "Raja Ferry Pier", "18:30", "Lipa Noi Pier", "140 THB"  },
            {"Don Sak", "Ko Samui", "Raja", "18:00", "Raja Ferry Pier", "19:30", "Lipa Noi Pier", "140 THB" },
            {"Don Sak", "Ko Samui", "Raja", "19:30", "Raja Ferry Pier", "21:00", "Lipa Noi Pier", "140 THB" }
    };

    private static String[][] samuiDonsak = {
            {"Ko Samui", "Don Sak", "Raja", "07:00", "Lipa Noi Pier", "08:30", "Raja Ferry Pier", "140 THB"},
            {"Ko Samui", "Don Sak", "Raja", "08:00", "Lipa Noi Pier", "09:30", "Raja Ferry Pier", "140 THB"},
            {"Ko Samui", "Don Sak", "Raja", "09:00", "Lipa Noi Pier", "10:30", "Raja Ferry Pier", "140 THB"},
            {"Ko Samui", "Don Sak", "Seatran", "09:00", "Bangrak Pier", "10:30", "Seatran Ferry Pier", "350 THB"},
            {"Ko Samui", "Don Sak", "Raja", "10:00", "Lipa Noi Pier", "11:30", "Raja Ferry Pier", "140 THB"},
            {"Ko Samui", "Don Sak", "Raja", "11:00", "Lipa Noi Pier", "12:30", "Raja Ferry Pier", "140 THB"},
            {"Ko Samui", "Don Sak", "Seatran", "11:30", "Bangrak Pier", "13:00", "Seatran Ferry Pier", "350 THB" },
            {"Ko Samui", "Don Sak",  "Raja", "17:00", "Lipa Noi Pier", "18:30", "Raja Ferry Pier", "140 THB"  },
            {"Ko Samui", "Don Sak", "Raja", "18:00", "Lipa Noi Pier", "19:30", "Raja Ferry Pier", "140 THB" },
            {"Ko Samui", "Don Sak", "Raja", "19:00", "Lipa Noi Pier", "20:30", "Raja Ferry Pier", "140 THB" }
    };

    private static String[][] samuiPhangan = {
            {"Ko Samui", "Ko Phangan", "Lomprayah", "08:00", "Pralan Pier", "08:20", "Thong Sala Pier", "300 THB"},
            {"Ko Samui", "Ko Phangan", "Seatran", "08:00", "Bangrak Pier", "08:30", "Thong Sala Pier", "300 THB"},
            {"Ko Samui", "Ko Phangan", "Raja", "09:00", "Lipa Noi Pier", "10:30", "Thong Sala Pier", "150 THB"},
            {"Ko Samui", "Ko Phangan", "Haadrin Queen", "10:30", "Big Buddha Pier", "11:20", "Haadrin Pier", "200 THB"},
            {"Ko Samui", "Ko Phangan", "Lomprayah", "11:15", "Nathon Pier", "11:45", "Thong Sala Pier", "300 THB"},
            {"Ko Samui", "Ko Phangan", "Songserm", "11:30", "Nathon Pier", "12:15", "Thong Sala Pier", "200 THB" },
            {"Ko Samui", "Ko Phangan", "Raja", "12:00", "Lipa Noi Pier", "13:30", "Thong Sala Pier", "150 THB"  },
            {"Ko Samui", "Ko Phangan", "Lomprayah", "12:30", "Pralan Pier", "12:50", "Thong Sala Pier", "300 THB" },
            {"Ko Samui", "Ko Phangan", "Seatran", "13:00", "Bangrak Pier", "13:30", "Thong Sala Pier", "300 THB"},
            {"Ko Samui", "Ko Phangan", "Haadrin Queen", "13:00", "Big Buddha Pier", "13:50", "Haadrin Pier", "200 THB"},
            {"Ko Samui", "Ko Phangan", "Lomprayah", "13:30", "Nathon Pier", "14:00", "Thong Sala Pier", "300 THB" },
            {"Ko Samui", "Ko Phangan", "Raja", "14:00", "Lipa Noi Pier", "15:30", "Thong Sala Pier", "150 THB" },
            {"Ko Samui", "Ko Phangan", "Haadrin Queen", "16:00", "Big Buddha Pier", "16:50", "Haadrin Pier", "200 THB"},
            {"Ko Samui", "Ko Phangan", "Seatran", "16:30", "Bangrak Pier", "17:00", "Thong Sala Pier", "300 THB"},
            {"Ko Samui", "Ko Phangan", "Lomprayah", "17:30", "Nathon Pier", "18:00", "Thong Sala Pier", "300 THB" },
            {"Ko Samui", "Ko Phangan", "Songserm", "17:30", "Nathon Pier", "18:15", "Thong Sala Pier", "200 THB" },
            {"Ko Samui", "Ko Phangan", "Raja", "18:00", "Lipa Noi Pier", "19:30", "Thong Sala Pier", "150 THB" },
            {"Ko Samui", "Ko Phangan", "Haadrin Queen", "18:30", "Big Buddha Pier", "19:20", "Haadrin Pier", "200 THB"},
    };

    private static String[][] phanganSamui = {
            {"Ko Phangan", "Ko Samui", "Raja", "07:00", "Thong Sala Pier", "08:30", "Lipa Noi Pier", "150 THB"},
            {"Ko Phangan", "Ko Samui", "Songserm", "07:00", "Thong Sala Pier", "07:45", "Nathon Pier", "200 THB" },
            {"Ko Phangan", "Ko Samui", "Lomprayah", "07:20", "Thong Sala Pier", "07:50", "Nathon Pier", "300 THB"},
            {"Ko Phangan", "Ko Samui", "Seatran", "08:00", "Thong Sala Pier", "08:30", "Bangrak Pier", "300 THB"},
            {"Ko Phangan", "Ko Samui", "Haadrin Queen", "09:30", "Haadrin Pier", "10:20", "Big Buddha Pier", "200 THB"},
            {"Ko Phangan", "Ko Samui", "Seatran", "10:30", "Thong Sala Pier", "11:00", "Bangrak Pier", "300 THB"},
            {"Ko Phangan", "Ko Samui", "Lomprayah", "11:00", "Thong Sala Pier", "11:20", "Pralan Pier", "300 THB"},
            {"Ko Phangan", "Ko Samui", "Haadrin Queen", "11:40", "Haadrin Pier", "12:30", "Big Buddha Pier", "200 THB"},
            {"Ko Phangan", "Ko Samui", "Lomprayah", "12:00", "Thong Sala Pier", "12:30", "Nathon Pier", "300 THB"},
            {"Ko Phangan", "Ko Samui", "Raja", "12:00", "Thong Sala Pier", "13:30", "Lipa Noi Pier", "150 THB"  },
            {"Ko Phangan", "Ko Samui", "Songserm", "12:30", "Thong Sala Pier", "13:45", "Nathon Pier", "200 THB" },
            {"Ko Phangan", "Ko Samui", "Raja", "14:00", "Thong Sala Pier", "15:30", "Lipa Noi Pier", "150 THB" },
            {"Ko Phangan", "Ko Samui", "Lomprayah", "14:30", "Thong Sala Pier", "15:00", "Nathon Pier", "300 THB" },
            {"Ko Phangan", "Ko Samui", "Haadrin Queen", "14:30", "Haadrin Pier", "15:20", "Big Buddha Pier", "200 THB"},
            {"Ko Phangan", "Ko Samui", "Lomprayah", "16:20", "Thong Sala Pier", "16:40", "Pralan Pier", "300 THB" },
            {"Ko Phangan", "Ko Samui", "Seatran", "16:30", "Thong Sala Pier", "17:00", "Bangrak Pier", "300 THB"},
            {"Ko Phangan", "Ko Samui", "Raja", "17:30", "Thong Sala Pier", "19:00", "Lipa Noi Pier", "150 THB" },
            {"Ko Phangan", "Ko Samui", "Haadrin Queen", "17:30", "Haadrin Pier", "18:20", "Big Buddha Pier", "200 THB"},
    };

    private static String[][] samuiKotao = {
            {"Ko Samui", "Ko Tao", "Lomprayah", "08:00", "Pralan Pier", "09:30", "Mae Haad Pier", "600 THB"},
            {"Ko Samui", "Ko Tao", "Seatran", "08:00", "Bangrak Pier", "10:00", "Mae Haad Pier", "600 THB"},
            {"Ko Samui", "Ko Tao", "Lomprayah", "11:15", "Nathon Pier", "14:15", "Mae Haad Pier", "600 THB"},
            {"Ko Samui", "Ko Tao", "Songserm", "11:30", "Nathon Pier", "14:00", "Mae Haad Pier", "500 THB" },
            {"Ko Samui", "Ko Tao", "Lomprayah", "12:30","Pralan Pier",  "14:15", "Mae Haad Pier", "600 THB"},
            {"Ko Samui", "Ko Tao", "Seatran", "13:00", "Bangrak Pier", "15:00", "Mae Haad Pier", "600 THB"},
            {"Ko Samui", "Ko Tao", "Seatran", "16:30", "Bangrak Pier", "18:30", "Mae Haad Pier", "600 THB"},
            {"Ko Samui", "Ko Tao", "Lomprayah", "17:30", "Nathon Pier", "19:15", "Mae Haad Pier", "700 THB"},
    };

    private static String[][] kotaoSamui = {
            {"Ko Tao", "Ko Samui", "Lomprayah", "06:00", "Mae Haad Pier", "07:50", "Nathon Pier", "700 THB"},
            {"Ko Tao", "Ko Samui", "Seatran", "06:30", "Mae Haad Pier", "08:30", "Bangrak Pier", "600 THB"},
            {"Ko Tao", "Ko Samui", "Seatran", "09:00", "Mae Haad Pier", "11:00", "Bangrak Pier", "600 THB"},
            {"Ko Tao", "Ko Samui", "Lomprayah", "09:30", "Mae Haad Pier", "11:20", "Pralan Pier", "600 THB"},
            {"Ko Tao", "Ko Samui", "Songserm", "10:00", "Mae Haad Pier", "13:15", "Nathon Pier", "500 THB" },
            {"Ko Tao", "Ko Samui", "Seatran", "15:00", "Mae Haad Pier", "17:30", "Bangrak Pier", "600 THB"},
            {"Ko Tao", "Ko Samui", "Lomprayah", "15:00", "Mae Haad Pier", "16:40", "Pralan Pier", "600 THB"},
    };

    private static String[][] phanganKotao = {
            {"Ko Phangan", "Ko Tao", "Lomprayah", "08:30", "Thong Sala Pier", "09:30", "Mae Haad Pier", "500 THB"},
            {"Ko Phangan", "Ko Tao", "Seatran", "08:30", "Thong Sala Pier", "10:00", "Mae Haad Pier", "450 THB"},
            {"Ko Phangan", "Ko Tao", "Songserm", "12:30", "Thong Sala Pier", "14:00", "Mae Haad Pier", "350 THB" },
            {"Ko Phangan", "Ko Tao", "Lomprayah", "13:00", "Thong Sala Pier", "14:15", "Mae Haad Pier", "500 THB"},
            {"Ko Phangan", "Ko Tao", "Seatran", "13:30", "Thong Sala Pier", "15:00", "Mae Haad Pier", "450 THB"},
            {"Ko Phangan", "Ko Tao", "Seatran", "17:00", "Thong Sala Pier", "18:30", "Mae Haad Pier", "450 THB"},
            {"Ko Phangan", "Ko Tao", "Lomprayah", "18:15", "Thong Sala Pier", "19:15", "Mae Haad Pier", "500 THB"},
    };

    private static String[][] kotaoPhangan = {
            {"Ko Tao", "Ko Phangan", "Lomprayah", "06:00", "Mae Haad Pier", "07:10", "Thong Sala Pier", "600 THB"},
            {"Ko Tao", "Ko Phangan", "Seatran", "06:30", "Mae Haad Pier", "08:00", "Thong Sala Pier", "450 THB"},
            {"Ko Tao", "Ko Phangan", "Seatran", "09:00", "Mae Haad Pier", "10:30", "Thong Sala Pier", "450 THB"},
            {"Ko Tao", "Ko Phangan", "Lomprayah", "09:30", "Mae Haad Pier", "10:45", "Thong Sala Pier", "500 THB"},
            {"Ko Tao", "Ko Phangan", "Songserm", "10:00", "Mae Haad Pier", "11:30", "Thong Sala Pier", "350 THB" },
            {"Ko Tao", "Ko Phangan", "Seatran", "15:00", "Mae Haad Pier", "16:30", "Thong Sala Pier", "450 THB"},
            {"Ko Tao", "Ko Phangan", "Lomprayah", "15:00", "Mae Haad Pier", "16:10", "Thong Sala Pier", "500 THB"},
    };
}
