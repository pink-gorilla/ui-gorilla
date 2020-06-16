(ns example.leaflet
  (:require
   [reagent.core :as r]
   ["react-leaflet" :refer [Map Marker TileLayer]]
   [pinkgorilla.ui.data.leaflet :refer [leaflet-map]]
   [pinkgorilla.ui.control.select :refer [select-map]]
   [demo.example :as example]))

(def center [51.505, -0.09])

(def rectangle  [[51.49, -0.08]
                 [51.5, -0.06]])

(def polygon [[51.515, -0.09]
              [51.52, -0.1]
              [51.52, -0.12]])

(def multiPolygon [[[51.51, -0.12]
                    [51.51, -0.13]
                    [51.53, -0.13]]
                   [[51.51, -0.05]
                    [51.51, -0.07]
                    [51.53, -0.07]]])

(def polyline [[51.505, -0.09]
               [51.51, -0.1]
               [51.51, -0.12]])

(def multi-polyline [[[51.5, -0.1]
                      [51.5, -0.12]
                      [51.52, -0.12]]
                     [[51.5, -0.05]
                      [51.5, -0.06]
                      [51.52, -0.06]]])

(def geojson
  [{:type "Feature" :geometry {:type "Polygon" :coordinates [[[-0.1091766357421875,51.51071897849311],[-0.11012077331542969,51.514084206610455],[-0.1050567626953125,51.517235544032154],[-0.09758949279785156,51.520066220569944],[-0.09690284729003906,51.522736508860255],[-0.0953364372253418,51.522456135946825],[-0.09429574012756348,51.52055355986299],[-0.08364200592041016,51.51795658211353],[-0.08016586303710938,51.51598037643901],[-0.07544517517089844,51.51344322994464],[-0.07617473602294922,51.51018479243817],[-0.07630348205566406,51.50692612186487],[-0.08162498474121094,51.508234960183415],[-0.0899505615234375,51.508956140741624],[-0.09685993194580078,51.510398467611765]]]} :properties {:name "City"}}
   {:type "Feature" :geometry {:type "Polygon" :coordinates [[[-0.1487445831298828,51.48587270045831],[-0.1389598846435547,51.48448304634681],[-0.13286590576171875,51.48533822311959],[-0.12359619140625,51.49212561988668],[-0.12067794799804688,51.50874245880332],[-0.11072158813476562,51.51029163015023],[-0.11057138442993164,51.51095936017433],[-0.11110782623291016,51.51381713409578],[-0.11460542678833008,51.51586019900402],[-0.11855363845825195,51.514872061405725],[-0.12267351150512695,51.51501894808078],[-0.12715816497802734,51.51278889029523],[-0.12908935546875,51.513416522387836],[-0.13033390045166016,51.51632755391457],[-0.13564467430114746,51.51935856792906],[-0.1433318853378296,51.52401151628708],[-0.14324873685836792,51.524695733301805],[-0.14415130019187927,51.524730778286745],[-0.14423780143260956,51.52402737021231],[-0.14510717242956161,51.52393600146223],[-0.15267133712768555,51.53748702947935],[-0.16351282596588135,51.53477422679169],[-0.17590731382369995,51.53978427653313],[-0.1793278008699417,51.53976884515872],[-0.1847223937511444,51.538098472208794],[-0.18835745751857758,51.53455941462763],[-0.1900184154510498,51.5346507620601],[-0.1965227723121643,51.52733404460455],[-0.19829437136650085,51.527840496109185],[-0.1978497952222824,51.5304431674846],[-0.20342107862234116,51.5325453448641],[-0.21393148228526115,51.531567476331844],[-0.21568715572357178,51.527973157104284],[-0.20684927701950073,51.52642291832361],[-0.20075663924217224,51.5224703215226],[-0.200284905731678,51.52112162900607],[-0.18899833783507347,51.510031734459055],[-0.18663816154003143,51.502412094159304],[-0.1597520336508751,51.50242524246215],[-0.1566515676677227,51.49027532356215]]]} :properties {:name "Wesminster"}}
   {:type "Feature" :geometry {:type "Polygon" :coordinates [[[-0.07518768310546875,51.514084206610455],[-0.08248329162597656,51.51798328700846],[-0.07604598999023438,51.521882033642676],[-0.07767677307128906,51.52642124957741],[-0.07264092564582825,51.53049614546567],[-0.06571680307388306,51.53115356788194],[-0.06251156330108643,51.53460404558779],[-0.05962014198303223,51.53344279215503],[-0.05109071731567383,51.53603221320984],[-0.044846534729003906,51.53501781838798],[-0.03321647644042969,51.54387966173666],[-0.02162933349609375,51.54142414303853],[-0.017337799072265625,51.53063964456954],[-0.00858306884765625,51.52594064813257],[-0.004119873046875,51.51686166794058],[0.009098052978515625,51.50799456412721],[0,51.50788772102843],[-0.0038194656372070312,51.50591107850855],[-0.0076389312744140625,51.50286581276562],[-0.002918243408203125,51.488865657782796],[-0.00823974609375,51.48678129755648],[-0.014591217041015625,51.485552014806856],[-0.022230148315429688,51.487582985843055],[-0.02712249755859375,51.49196529933168],[-0.028066635131835938,51.49730901400833],[-0.027637481689453125,51.50564395807757],[-0.03948211669921875,51.51034504891231],[-0.048923492431640625,51.50810140697543],[-0.058536529541015625,51.502758957640296],[-0.075531005859375,51.50671243040582]]]} :properties {:name "Tower Hamlets"}}])


(def state (r/atom {:location :london}))

(defn demo []
  [:<>
   [:h2 "select the map you like"]
   [select-map {:nav? true} [:london :coronado] state :location]

   (case (:location @state)
     :london     [leaflet-map
                  [{:type :view :center [51.49, -0.08] :zoom 12 :height 600 :width 700}
                   {:type :rectangle :bounds rectangle}
                   {:type :circle :center center :fillColor "blue" :radius 200}
                   {:type :polygon :positions polygon :color "purple"}
                   {:type :polygon :positions multiPolygon :color "purple"}
                   {:type :line :positions polyline :color "lime"}
                   {:type :line :positions multi-polyline :color "lime"}
                   {:type :marker :position [51.505, -0.09]}
                   {:type :marker :position [51.51, -0.12] :popup "wow"}
                   {:type :circlemarker :center [51.52, -0.06] :fillColor "blue" :radius 200 :popup "square the circle"}
                   {:type :geojson :data geojson}]]
     :coronado [leaflet-map
                [;{:type :view :center [51.49, -0.08]}  ; no center -> no visible features, but will show panamas nicest beach
                 {:type :rectangle :bounds rectangle}]])])

(example/add
 "leaflet" [demo])
