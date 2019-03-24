(ns ^:figwheel-no-load muggle.dev
  (:require
    [muggle.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)
