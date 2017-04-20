(ns example-clj.seesaw
  (:use seesaw.core))

(def btn (button :text "Start"))
(def lbl (label "Enter your message"))
(def field (text "This is a text field."))
(def m-list-box (listbox :model (-> ["List 1" "List 2" "List 3"]) ))

(def panel (flow-panel :items [btn lbl m-list-box field]))


(def f (frame :title "Dashboard" :content panel :on-close :dispose))
(listen btn :action (fn [e] (alert "button is started")) )
(listen btn :mouse-entered #(config! % :foreground :blue)
          :mouse-exited  #(config! % :foreground :red))

(-> f pack! show!)