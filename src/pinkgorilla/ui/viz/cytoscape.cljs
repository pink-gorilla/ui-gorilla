(ns pinkgorilla.ui.viz.cytoscape
  (:require
   [re-frame.core :as rf]
   ["cytoscape" :as cytoscope]
   ["cytoscape-cose-bilkent" :as cose-bilkent]
   ["cytoscape-dagre" :as dagre]
   ["react-cytoscapejs" :as CytoscapeComponent]
   [pinkgorilla.ui.box :refer [box]]))

(.use cytoscope cose-bilkent)
(.use cytoscope dagre);

(defn ^{:category :data}
  cytoscape
  [data]
  [:> CytoscapeComponent data])

(defn ^{:category :data}
  cytoscape-boxed
  "reagent component to render highchart-spec via highcharts.js
   Usage:  [:p/highchart spec-as-clj-data]"
  [data]
  [box {:s :small
        :render cytoscape
        :data data}])



; https://js.cytoscape.org/
; https://github.com/plotly/react-cytoscapejs


; other options:
; http://www.graphviz.org/
; geschichte