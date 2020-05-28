(ns example.controls
  (:require
   [cljs.pprint]
   [reagent.core :as r]
   [demo.example :as example]))


(example/add
 "tab"
 [:div
  [:ul {:class "list-reset flex border-b"}
   [:li {:class "-mb-px mr-1"}
    [:a {:class "bg-white inline-block border-l border-t border-r rounded-t py-2 px-4 text-blue-dark font-semibold", :href "#"} "Active"]]
   [:li {:class "mr-1"}
    [:a {:class "bg-white inline-block py-2 px-4 text-blue hover:text-blue-darker font-semibold", :href "#"} "Tab"]]
   [:li {:class "mr-1"}
    [:a {:class "bg-white inline-block py-2 px-4 text-blue hover:text-blue-darker font-semibold", :href "#"} "Tab"]]
   [:li {:class "mr-1"}
    [:a {:class "bg-white inline-block py-2 px-4 text-grey-light font-semibold", :href "#"} "Tab"]]]])

(example/add
 "controls"
 (let [items ["javascript" "ruby" "clojure" "clojurescript" "ocaml" "scheme" "elixir" "c#" "R" "python"]
       v (r/atom "ruby")]
   [:<>

    [:h1 "ui controls (with tailwind css)"]

    [:h2 "Button"]
    [:p/button1]

    [:h2 "Tabs"]
    [:p/tabs
     [:p/tab {:title "a"
       :isActive false
       :color "red"
       :tabIndex 1}
      [:h4 "We love the A-team !"]]
     [:p/tab {:title "b"
       :isActive true
       :color "green"
       :tabIndex 0}
      [:h4 "Bananas are a great potassium source!"]]]

    [:h2 "select"]
    [:p/pselect items v]


    [:h2 "slider"]
    [:p/slider]

    [:h2 "Popover"]
    [:p/popover {:color "orange"
                 :placement "left"
                 :button-text "orange-l"}
     [:p/tooltip {:color "orange"
               :title  "oranges"
               :content "Lets make orange juice"}]
     ]
    [:p/popover {:color "green"
                 :placement "right"
                 :button-text "trees-r"}
     [:p/tooltip {:color "green"
               :title  "tree"
               :content "How many trees are in a forest?"}]]
    
    [:h2 "progress bar"]
    [:p/progressbar 30]
    [:p/progressbar 80]

    [:p "born with grosse ohrn"]]))