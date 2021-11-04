
(defn data [nr]
  (let [d (vec (take nr (repeatedly rand)))
       ; _ (println "d is:" d)
        ]
    d))

(def data-20 (data 20))
(def data-40 (data 40))
(def data-100 (data 100))
(def data-150 (data 150))

[:div
 [spark/line {:data data-20 :limit 20
                        ;:width 100 :height 20
                        ;:svgWidth 300 :svgHeight 20
                        ;:margin 5
              }]
 [spark/line {:data data-20 :limit 20
              :width 100 :height 20
              :svgWidth 300 :svgHeight 20
              :margin 5}]

 [:p/sparkline {:data data-20 :limit 20
                :width 100 :height 20
                :svgWidth 300 :svgHeight 20
                :margin 5}]
 [:p/sparkline {:data data-40 :limit 40
                :width 100 :height 20
                :svgWidth 300 :svgHeight 20
                :margin 5}]
 [:p/sparklinespot {:data data-100 :limit 100
                    :svgWidth 300 :svgHeight 20
                    :margin 10}]
 [:p/sparklinebar {:data [50, 10, 5, 20, 10 6 7 88 50 30 60] :limit 10
                   :svgWidth 300 :svgHeight 20
                   :margin 10}]
 [:p/sparklinebar {:data data-150 :limit 50
                   :svgWidth 300 :svgHeight 20
                   :margin 1}]]