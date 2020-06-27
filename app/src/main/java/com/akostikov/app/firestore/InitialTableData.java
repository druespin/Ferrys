package com.akostikov.app.firestore;

public interface InitialTableData {

    String[][] DONSAK_KOTAO = {

            {"Seatran", "11:00", "Seatran Ferry Pier", "15:00", "Mae Haad Pier", "700 THB"},
            {"Seatran", "14:30", "Seatran Ferry Pier", "18:30", "Mae Haad Pier", "700 THB"},
    };

    String[][] KOTAO_DONSAK = {
            {"Seatran", "06:30", "Mae Haad Pier", "10:30", "Seatran Ferry Pier", "700 THB"},
            {"Seatran", "09:00", "Mae Haad Pier", "13:00", "Seatran Ferry Pier", "700 THB"}
    };

    String[][] DONSAK_PHANGAN = {
        {"Raja", "06:00", "Raja Ferry Pier", "08:30", "Thong Sala Pier", "210 THB"},
        {"Raja", "08:00", "Raja Ferry Pier", "10:30", "Thong Sala Pier", "210 THB"},
        {"Raja", "10:00", "Raja Ferry Pier", "12:30", "Thong Sala Pier", "210 THB"},
        {"Seatran", "11:00", "Seatran Ferry Pier", "13:30", "Thong Sala Pier", "450 THB"},
        {"Raja", "14:00", "Raja Ferry Pier", "16:30", "Thong Sala Pier", "210 THB"},
        {"Seatran", "14:30", "Seatran Ferry Pier", "17:00", "Thong Sala Pier", "450 THB"},
        {"Raja", "16:00", "Raja Ferry Pier", "18:30", "Thong Sala Pier", "210 THB"},
        {"Raja", "18:00", "Raja Ferry Pier", "20:30", "Thong Sala Pier", "210 THB" }
    };

    String[][] PHANGAN_DONSAK = {
            {"Raja", "05:00", "Thong Sala Pier", "07:30", "Raja Ferry Pier", "210 THB"},
            {"Raja", "07:00", "Thong Sala Pier", "09:30", "Raja Ferry Pier", "210 THB"},
            {"Seatran", "08:00", "Thong Sala Pier", "10:30", "Seatran Ferry Pier", "450 THB" },
            {"Seatran", "10:30", "Thong Sala Pier", "13:00", "Seatran Ferry Pier", "450 THB" },
            {"Raja", "11:00", "Thong Sala Pier", "13:30", "Raja Ferry Pier", "210 THB"},
            {"Raja", "13:00", "Thong Sala Pier", "15:30", "Raja Ferry Pier", "210 THB"},
            {"Raja", "17:00", "Thong Sala Pier", "19:30", "Raja Ferry Pier", "210 THB"}
    };

    String[][] DONSAK_SAMUI = {
            { "Raja", "07:00", "Raja Ferry Pier", "08:30", "Lipa Noi Pier", "140 THB"},
            { "Raja", "08:00", "Raja Ferry Pier", "09:30", "Lipa Noi Pier", "140 THB"},
            { "Raja", "09:00", "Raja Ferry Pier", "10:30", "Lipa Noi Pier", "140 THB"},
            { "Raja", "10:00", "Raja Ferry Pier", "11:30", "Lipa Noi Pier", "140 THB"},
            { "Raja", "11:00", "Raja Ferry Pier", "12:30", "Lipa Noi Pier", "140 THB"},
            { "Seatran", "11:00", "Seatran Ferry Pier", "12:30", "Bangrak Pier", "350 THB" },
            { "Seatran", "14:30", "Seatran Ferry Pier", "16:00", "Bangrak Pier", "350 THB" },
            { "Raja", "17:00", "Raja Ferry Pier", "18:30", "Lipa Noi Pier", "140 THB"  },
            { "Raja", "18:00", "Raja Ferry Pier", "19:30", "Lipa Noi Pier", "140 THB" },
            { "Raja", "19:30", "Raja Ferry Pier", "21:00", "Lipa Noi Pier", "140 THB" }
    };

    String[][] SAMUI_DONSAK = {
            {"Raja", "07:00", "Lipa Noi Pier", "08:30", "Raja Ferry Pier", "140 THB"},
            {"Raja", "08:00", "Lipa Noi Pier", "09:30", "Raja Ferry Pier", "140 THB"},
            {"Raja", "09:00", "Lipa Noi Pier", "10:30", "Raja Ferry Pier", "140 THB"},
            {"Seatran", "09:00", "Bangrak Pier", "10:30", "Seatran Ferry Pier", "350 THB"},
            {"Raja", "10:00", "Lipa Noi Pier", "11:30", "Raja Ferry Pier", "140 THB"},
            {"Raja", "11:00", "Lipa Noi Pier", "12:30", "Raja Ferry Pier", "140 THB"},
            { "Seatran", "11:30", "Bangrak Pier", "13:00", "Seatran Ferry Pier", "350 THB" },
            { "Raja", "17:00", "Lipa Noi Pier", "18:30", "Raja Ferry Pier", "140 THB"  },
            { "Raja", "18:00", "Lipa Noi Pier", "19:30", "Raja Ferry Pier", "140 THB" },
            { "Raja", "19:00", "Lipa Noi Pier", "20:30", "Raja Ferry Pier", "140 THB" }
    };

   String[][] SAMUI_PHANGAN = {
            {"Lomprayah", "08:00", "Pralan Pier", "08:20", "Thong Sala Pier", "300 THB"},
            {"Seatran", "08:00", "Bangrak Pier", "08:30", "Thong Sala Pier", "300 THB"},
            {"Raja", "09:00", "Lipa Noi Pier", "10:30", "Thong Sala Pier", "150 THB"},
            {"Haadrin Queen", "10:30", "Big Buddha Pier", "11:20", "Haadrin Pier", "200 THB"},
            {"Lomprayah", "11:15", "Nathon Pier", "11:45", "Thong Sala Pier", "300 THB"},
            {"Songserm", "11:30", "Nathon Pier", "12:15", "Thong Sala Pier", "200 THB" },
            {"Raja", "12:00", "Lipa Noi Pier", "13:30", "Thong Sala Pier", "150 THB"  },
            {"Lomprayah", "12:30", "Pralan Pier", "12:50", "Thong Sala Pier", "300 THB" },
            {"Seatran", "13:00", "Bangrak Pier", "13:30", "Thong Sala Pier", "300 THB"},
            {"Haadrin Queen", "13:00", "Big Buddha Pier", "13:50", "Haadrin Pier", "200 THB"},
            {"Lomprayah", "13:30", "Nathon Pier", "14:00", "Thong Sala Pier", "300 THB" },
            { "Raja", "14:00", "Lipa Noi Pier", "15:30", "Thong Sala Pier", "150 THB" },
            {"Haadrin Queen", "16:00", "Big Buddha Pier", "16:50", "Haadrin Pier", "200 THB"},
            {"Seatran", "16:30", "Bangrak Pier", "17:00", "Thong Sala Pier", "300 THB"},
            {"Lomprayah", "17:30", "Nathon Pier", "18:00", "Thong Sala Pier", "300 THB" },
            {"Songserm", "17:30", "Nathon Pier", "18:15", "Thong Sala Pier", "200 THB" },
            { "Raja", "18:00", "Lipa Noi Pier", "19:30", "Thong Sala Pier", "150 THB" },
            {"Haadrin Queen", "18:30", "Big Buddha Pier", "19:20", "Haadrin Pier", "200 THB"},
    };

    String[][] PHANGAN_SAMUI = {
            {"Raja", "07:00", "Thong Sala Pier", "08:30", "Lipa Noi Pier", "150 THB"},
            {"Songserm", "07:00", "Thong Sala Pier", "07:45", "Nathon Pier", "200 THB" },
            {"Lomprayah", "07:20", "Thong Sala Pier", "07:50", "Nathon Pier", "300 THB"},
            {"Seatran", "08:00", "Thong Sala Pier", "08:30", "Bangrak Pier", "300 THB"},
            {"Haadrin Queen", "09:30", "Haadrin Pier", "10:20", "Big Buddha Pier", "200 THB"},
            {"Seatran", "10:30", "Thong Sala Pier", "11:00", "Bangrak Pier", "300 THB"},
            {"Lomprayah", "11:00", "Thong Sala Pier", "11:20", "Pralan Pier", "300 THB"},
            {"Haadrin Queen", "11:40", "Haadrin Pier", "12:30", "Big Buddha Pier", "200 THB"},
            {"Lomprayah", "12:00", "Thong Sala Pier", "12:30", "Nathon Pier", "300 THB"},
            {"Raja", "12:00", "Thong Sala Pier", "13:30", "Lipa Noi Pier", "150 THB"  },
            {"Songserm", "12:30", "Thong Sala Pier", "13:45", "Nathon Pier", "200 THB" },
            { "Raja", "14:00", "Thong Sala Pier", "15:30", "Lipa Noi Pier", "150 THB" },
            {"Lomprayah", "14:30", "Thong Sala Pier", "15:00", "Nathon Pier", "300 THB" },
            {"Haadrin Queen", "14:30", "Haadrin Pier", "15:20", "Big Buddha Pier", "200 THB"},
            {"Lomprayah", "16:20", "Thong Sala Pier", "16:40", "Pralan Pier", "300 THB" },
            {"Seatran", "16:30", "Thong Sala Pier", "17:00", "Bangrak Pier", "300 THB"},
            { "Raja", "17:30", "Thong Sala Pier", "19:00", "Lipa Noi Pier", "150 THB" },
            {"Haadrin Queen", "17:30", "Haadrin Pier", "18:20", "Big Buddha Pier", "200 THB"},
    };

    String[][] SAMUI_TAO = {
            {"Lomprayah", "08:00", "Pralan Pier", "09:30", "Mae Haad Pier", "600 THB"},
            {"Seatran", "08:00", "Bangrak Pier", "10:00", "Mae Haad Pier", "600 THB"},
            {"Lomprayah", "11:15", "Nathon Pier", "14:15", "Mae Haad Pier", "600 THB"},
            {"Songserm", "11:30", "Nathon Pier", "14:00", "Mae Haad Pier", "500 THB" },
            {"Lomprayah", "12:30","Pralan Pier",  "14:15", "Mae Haad Pier", "600 THB"},
            {"Seatran", "13:00", "Bangrak Pier", "15:00", "Mae Haad Pier", "600 THB"},
            {"Seatran", "16:30", "Bangrak Pier", "18:30", "Mae Haad Pier", "600 THB"},
            {"Lomprayah", "17:30", "Nathon Pier", "19:15", "Mae Haad Pier", "700 THB"},
    };

    String[][] TAO_SAMUI = {
            {"Lomprayah", "06:00", "Mae Haad Pier", "07:50", "Nathon Pier", "700 THB"},
            {"Seatran", "06:30", "Mae Haad Pier", "08:30", "Bangrak Pier", "600 THB"},
            {"Seatran", "09:00", "Mae Haad Pier", "11:00", "Bangrak Pier", "600 THB"},
            {"Lomprayah", "09:30", "Mae Haad Pier", "11:20", "Pralan Pier", "600 THB"},
            {"Songserm", "10:00", "Mae Haad Pier", "13:15", "Nathon Pier", "500 THB" },
            {"Seatran", "15:00", "Mae Haad Pier", "17:30", "Bangrak Pier", "600 THB"},
            {"Lomprayah", "15:00", "Mae Haad Pier", "16:40", "Pralan Pier", "600 THB"},
    };

    String[][] PHANGAN_TAO = {
            {"Lomprayah", "08:30", "Thong Sala Pier", "09:30", "Mae Haad Pier", "500 THB"},
            {"Seatran", "08:30", "Thong Sala Pier", "10:00", "Mae Haad Pier", "450 THB"},
            {"Songserm", "12:30", "Thong Sala Pier", "14:00", "Mae Haad Pier", "350 THB" },
            {"Lomprayah", "13:00", "Thong Sala Pier", "14:15", "Mae Haad Pier", "500 THB"},
            {"Seatran", "13:30", "Thong Sala Pier", "15:00", "Mae Haad Pier", "450 THB"},
            {"Seatran", "17:00", "Thong Sala Pier", "18:30", "Mae Haad Pier", "450 THB"},
            {"Lomprayah", "18:15", "Thong Sala Pier", "19:15", "Mae Haad Pier", "500 THB"},
    };

    String[][] TAO_PHANGAN = {
            {"Lomprayah", "06:00", "Mae Haad Pier", "07:10", "Thong Sala Pier", "600 THB"},
            {"Seatran", "06:30", "Mae Haad Pier", "08:00", "Thong Sala Pier", "450 THB"},
            {"Seatran", "09:00", "Mae Haad Pier", "10:30", "Thong Sala Pier", "450 THB"},
            {"Lomprayah", "09:30", "Mae Haad Pier", "10:45", "Thong Sala Pier", "500 THB"},
            {"Songserm", "10:00", "Mae Haad Pier", "11:30", "Thong Sala Pier", "350 THB" },
            {"Seatran", "15:00", "Mae Haad Pier", "16:30", "Thong Sala Pier", "450 THB"},
            {"Lomprayah", "15:00", "Mae Haad Pier", "16:10", "Thong Sala Pier", "500 THB"},
    };
}
