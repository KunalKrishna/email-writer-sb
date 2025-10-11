# email-writer-sb

# 🤖 Smart Email Assistant

An **AI-powered email assistant** that helps users read, summarize, compose, and manage emails intelligently — built with **Spring Boot**, **Spring AI**, and **React.js**, along with a companion **Google Chrome Extension** for seamless in-browser integration.

---

## ✨ Overview

**Smart Email Assistant** is a productivity tool designed to make handling emails faster and smarter.  
It connects to your mailbox (e.g., Gmail or Outlook), uses **Spring AI** to analyze and summarize messages, and can even **draft intelligent replies** or **extract action items** — all from one interface or directly inside your browser.

---

## 🚀 Key Features

- 📩 **Smart Email Summarization**  
  Uses LLMs (via **Spring AI**) to summarize long email threads into concise overviews.

- 🧠 **AI-Powered Reply Suggestions**  
  Generates context-aware draft responses in your tone and style.

- 🔍 **Email Intent Detection**  
  Automatically identifies tasks, meetings, or follow-ups mentioned in emails.

- 🧩 **Chrome Extension Integration**  
  Access the assistant directly inside Gmail — highlight an email, and get instant summaries or replies without leaving your inbox.

- ⚙️ **Spring Boot + Spring AI Backend**  
  Handles email parsing, AI prompt orchestration, and integration with mail APIs.

- 🧭 **React Frontend Dashboard**  
  Clean, intuitive UI for viewing inbox summaries, managing drafts, and customizing AI settings.

- 🔐 **Secure Authentication**  
  OAuth 2.0 integration with Gmail / Outlook APIs (for mailbox access).

---

## 🧱 Architecture

            ┌─────────────────────┐
            │   Gmail / Outlook   │
            └──────────┬──────────┘
                       │
             (OAuth API Integration)
                       │
    ┌─────────────────────────▼─────────────────────────┐
    │ Spring Boot Backend (Spring AI) │
    │ - REST APIs │
    │ - Email Processing / Summarization / Drafting │
    │ - AI Service Orchestration (OpenAI / Ollama) │
    └─────────────────────────┬─────────────────────────┘
                          │
    ┌───────────▼────────────┐
    │ React Frontend (Web UI)│
    └───────────┬────────────┘
            │
    ┌───────────▼────────────┐
    │ Chrome Extension (UI) │
    │ - Inline summaries │
    │ - Draft reply popup │
    └─────────────────────────┘

